package org.saucedemo.tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import org.saucedemo.base.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.nio.file.Paths;

/*
 * class: Base class
 * author: prasanna suman
 * purpose: to initiate or perform browser activities like launch/ close browser
 *
 * Note: This is for the assessment purpose, in order to run through CI, will check in the Env variables, if
 *  env variable is not available then we will read data from config file
 */
public class BaseTest {

	public Playwright playwright;
	public Browser browser;
	public BrowserContext context;
	public Page page;
	public PropertyFile pdata = new PropertyFile();

	@BeforeSuite
	public void openSuite() throws IOException {
			playwright = Playwright.create();
			LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(Boolean.valueOf(pdata.getData("headless")));
			Browser browser = getBrowserType(pdata.getData("browser")).launch(headless);
			context = browser.newContext();
			context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get(pdata.getData("videoDir"))));
			Boolean traceView = Boolean.valueOf(pdata.getData("traces"));
			context.tracing().start(
					new Tracing.StartOptions()
							.setScreenshots(traceView)
							.setSnapshots(traceView)
							.setSources(traceView)
			);

			page = context.newPage();
			page.navigate(pdata.getData("base_url"));
	}

	public BrowserType getBrowserType(String browserName) {
		BrowserType browserType;
		if(browserName.equals("chromium")){
			browserType = playwright.chromium();
		} else if(browserName.equals("firefox")){
			browserType = playwright.firefox();
		} else {
			browserType = playwright.webkit();
		}
		return browserType;
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		context.tracing().stop(
				new Tracing.StopOptions()
						.setPath(Paths.get(pdata.getData("tracePath")))
		);
		page.close();
		context.close();
		playwright.close();
	}
}