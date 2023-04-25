package org.saucedemo.tests;

import org.saucedemo.base.AutoConstant;
import org.saucedemo.pages.AuthPage;
import org.saucedemo.pages.InventoryPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTest extends BaseTest {

    @BeforeMethod
    public void login() {
        AuthPage authPage = new AuthPage(page);
        authPage.performLogin(AutoConstant.userName, AutoConstant.password);
    }

    @AfterMethod
    public void logOut() {
        AuthPage authPage = new AuthPage(page);
        authPage.performLogout();
    }

    @Test
    public void verifyAddSingleProduct() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.sortProduct(AutoConstant.sortValues.get("Price (high to low)"));
        inventoryPage.addProductToCart(AutoConstant.productName);
    }
}
