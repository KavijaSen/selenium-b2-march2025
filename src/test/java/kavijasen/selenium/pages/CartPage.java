package kavijasen.selenium.pages;

import kavijasen.selenium.util.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;
    private final ActionBot actionBot;

    private final By cartIcon = By.className("shopping_cart_link");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver, ActionBot actionBot) {
        this.driver = driver;
        this.actionBot = actionBot;
    }

    // Method to navigate to the Cart Page by clicking on the cart icon
    public void goToCart() {
        actionBot.waitAndClick(cartIcon);
    }

    // Method to get the page URL (Cart page)
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Method to click the Continue Shopping button
    public void clickContinueShopping() {
        actionBot.waitAndClick(continueShoppingButton);
    }


    // Method to click the Checkout button
    public void clickCheckout() {
        actionBot.waitAndClick(checkoutButton);
    }


}
