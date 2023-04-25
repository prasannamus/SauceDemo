package org.saucedemo.pages;

import com.microsoft.playwright.Page;
import org.saucedemo.utils.ElementActions;

import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(Page page) {
        super(page);
    }

    private final String sortProductsDropdown = "[data-test='product_sort_container']";
    private final String addToCartButton = "[data-test^='add-to-cart-']";


    public void sortProduct(String value) {
        elementActions.selectDropDownValue(sortProductsDropdown, value);

    }

    public void addProductToCart(int productNumber) {
        elementActions.clickButton(addToCartButton, productNumber-1);
    }


}
