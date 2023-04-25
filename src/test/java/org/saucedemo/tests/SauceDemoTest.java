package org.saucedemo.tests;

import org.saucedemo.base.AutoConstant;
import org.saucedemo.pages.AuthPage;
import org.saucedemo.pages.InventoryPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceDemoTest extends BaseTest {

    @BeforeMethod
    public void login() {
        AuthPage authPage = new AuthPage(page);
        authPage.performLogin(AutoConstant.userName, AutoConstant.password);
    }

    @AfterMethod
    public void logOut() throws InterruptedException {
        AuthPage authPage = new AuthPage(page);
        authPage.performLogout();
    }

    @Test
    public void verifyAddSingleProduct() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.sortProduct(AutoConstant.sortValues.get("Price (high to low)"));
        inventoryPage.emptyCartIfItemsPresent();
        inventoryPage.addProductToCart(AutoConstant.productName);
        assertThat(page.locator("[data-test^='add-to-cart-']")).hasCount(5);
    }

    @Test
    public void verifyMultipleProductsAddingToCart() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.sortProduct(AutoConstant.sortValues.get("Price (high to low)"));
        inventoryPage.emptyCartIfItemsPresent();
        inventoryPage.addMultipleProductsToCart(AutoConstant.productList);
        assertThat(page.locator("[data-test^='add-to-cart-']")).hasCount(3);
        // Alternatively we can use assertEquals(inventoryPage.addToCartButtonsCount(), 3); from TestNG
    }
}
