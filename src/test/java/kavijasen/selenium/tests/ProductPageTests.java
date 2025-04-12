package kavijasen.selenium.tests;

import kavijasen.selenium.pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class ProductPageTests {

    WebDriver driver;
    InventoryPage inventoryPage = new InventoryPage(driver);


    @Test
    public void testAddRandomProductsToCart() {
        int numberOfProductsToAdd = 3;
        inventoryPage.addRandomProductsToCart(numberOfProductsToAdd);


        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        int actualCount = Integer.parseInt(cartCount);
        assertEquals(actualCount, numberOfProductsToAdd, "Cart count does not match");
    }

    @Test
    public void testRemoveProductFromCart() {

        int numberOfProductsToAdd = 3;
        inventoryPage.addRandomProductsToCart(numberOfProductsToAdd);


        String cartCountBeforeRemove = driver.findElement(By.className("shopping_cart_badge")).getText();
        int initialCount = Integer.parseInt(cartCountBeforeRemove);


        inventoryPage.removeProductFromCart("Sauce Labs Backpack");


        String cartCountAfterRemove = driver.findElement(By.className("shopping_cart_badge")).getText();
        int updatedCount = Integer.parseInt(cartCountAfterRemove);


        assertEquals(updatedCount, initialCount - 1, "Cart count did not decrease correctly after removing a product");
    }


    }

