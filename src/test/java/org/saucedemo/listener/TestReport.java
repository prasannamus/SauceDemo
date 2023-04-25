package org.saucedemo.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class TestReport implements ITestListener, ISuiteListener {
    private static final String REPORT_PATH = "reports/report.html";
    private static final String REPORT_NAME = "Playwright Test Report";

    private ExtentReports extent;
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ISuite suite) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_PATH);
        sparkReporter.config().setReportName(REPORT_NAME);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().log(Status.SKIP, "Test skipped");
    }

}

