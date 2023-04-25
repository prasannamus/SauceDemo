package org.saucedemo.pages;

import com.microsoft.playwright.Page;
import org.saucedemo.base.AutoConstant;
import org.saucedemo.utils.ElementActions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BasePage {

    Page page;
    ElementActions elementActions;
    public BasePage(Page page) {
        this.page = page;
        elementActions = new ElementActions(page);
        assertTitle();
    }

    public void assertTitle() {
        assertThat(page).hasTitle(AutoConstant.webPageTitle);
    }
}
