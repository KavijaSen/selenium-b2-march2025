package kavijasen.selenium.tests;

import kavijasen.selenium.pages.CartPage;
import kavijasen.selenium.pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import kavijasen.selenium.util.ActionBot;

import java.time.Duration;

import static org.testng.Assert.*;

public class CartPageTest {

    WebDriver driver;
    InventoryPage inventoryPage;
    CartPage cartPage;
    ActionBot actionBot;

    @BeforeMethod
    public void beforeMethod() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Initialize the pages
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver, actionBot);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    // Verify that currently in the 'Cart' page
    @Test
    public void testVerifyCartPage() {
        cartPage.goToCart();
        boolean isCartPageTitleDisplayed = driver.findElement(By.cssSelector(".title[data-test='title']")).isDisplayed();
        assertTrue(isCartPageTitleDisplayed, "The 'Your Cart' title is not displayed.");
    }

    // Verify that the ContinueShoppingURL works
    @Test
    public void testContinueShoppingRedirectsToInventoryPage() {
        cartPage.clickContinueShopping();

        String currentUrl = cartPage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html", "The URL did not redirect to the Inventory page.");
    }

    // Verify that the CheckoutURL works
    @Test
    public void testCheckoutRedirectsToCheckoutPage() {
        cartPage.clickCheckout();

        String currentUrl = cartPage.getCurrentUrl();
        assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html", "The URL did not redirect to the Checkout page.");
    }

}
