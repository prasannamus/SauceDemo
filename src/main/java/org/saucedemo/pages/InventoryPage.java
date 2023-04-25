package org.saucedemo.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(Page page) {
        super(page);
    }

    private final String sortProductsDropdown = "[data-test='product_sort_container']";
    private final String addToCartButton = "[data-test^='add-to-cart-']";
    private final String removeFromCartButton = "[data-test^='remove-']";


    public void sortProduct(String value) {
        elementActions.selectDropDownValue(sortProductsDropdown, value);

    }

    public void addProductToCart(int productNumber) {
        elementActions.clickButton(addToCartButton, productNumber-1);
    }

    public void addProductToCart(String productName) {
        elementActions.clickButton("[data-test^='add-to-cart-"+ productName+"']");
    }

    public void addMultipleProductsToCart(List<Integer> productList) {
        for(int product: productList)
            addProductToCart(product);
    }

    // Added for TestNG assertion. But used Playwright assertion in tests
    public int addToCartButtonsCount() {
        return page.locator(addToCartButton).count();
    }

    public void emptyCartIfItemsPresent() {
        List<ElementHandle> removeButtons = page.querySelectorAll(removeFromCartButton);
        for (ElementHandle removeButton : removeButtons) {
            removeButton.click();
        }
    }
}
