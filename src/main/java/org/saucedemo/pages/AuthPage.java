package org.saucedemo.pages;

import com.microsoft.playwright.Page;
import org.saucedemo.utils.ElementActions;

public class AuthPage extends BasePage {

    public AuthPage(Page page) {
        super(page);
    }

    // Element Locators for Login Page
    private final String userNameInput = "user-name";
    private final String passwordInput = "password";
    private final String loginButton = "login-button";
    private final String menuButton = "#react-burger-menu-btn";
    private final String logOutLink = "#logout_sidebar_link";

    public void performLogin(String userName, String password) {
        elementActions.fillInput(userNameInput, userName);
        elementActions.fillInput(passwordInput, password);
        elementActions.clickInputButton(loginButton);
    }

    public void performLogout() {
        elementActions.clickButton(menuButton);
        elementActions.clickButton(logOutLink);
    }


}
