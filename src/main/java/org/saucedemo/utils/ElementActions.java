package org.saucedemo.utils;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class ElementActions {
    Page page;
    public ElementActions(Page page) {
        this.page = page;
    }

    public void fillInput(String name, String value) {
        Locator element;

        // Check if name value contains css selector[id/class] or xpath. It can extend
        if (name.contains(".") || name.contains("#") || name.contains("//")) {
            element = page.locator(name);
        } else {
            element = page.locator("input[name='" + name + "']");
        }
        if(element.isEditable() && element.isEnabled()) {
            element.fill(value);
        } else {
            throw new RuntimeException(name + " is not enabled/ editable");
        }
    }

    public void clickInputButton(String name) {
        Locator element;

        // Check if name value contains css selector[id/class] or xpath. It can extend
        if (name.contains(".") || name.contains("#") || name.contains("//")) {
            element = page.locator(name);
        } else {
            element = page.locator("input[name='" + name + "']");
        }
        if(element.isEnabled()) {
            element.click();
        } else {
            throw new RuntimeException(name + " is not enabled/ clickable");
        }
    }

    public void clickButton(String selector, int index) {
        Locator element = page.locator(selector).nth(index);
        if(element.isEnabled()) {
            element.click();
        } else {
            throw new RuntimeException(selector + " is not enabled/ clickable");
        }
    }

    public void clickButton(String selector) {
        Locator element = page.locator(selector);
        if(element.isEnabled()) {
            element.click();
        } else {
            throw new RuntimeException(selector + " is not enabled/ clickable");
        }
    }

    public void selectDropDownValue(String selector, String value) {
        Locator element = page.locator(selector);
        if(element.isEnabled()) {
            element.selectOption(new SelectOption().setValue(value));
        } else {
            throw new RuntimeException(selector + " is not enabled/ clickable");
        }
    }
}
