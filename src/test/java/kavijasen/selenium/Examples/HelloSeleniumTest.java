package kavijasen.selenium.Examples;

import kavijasen.selenium.support.locators.ByText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelloSeleniumTest {

    @Test
    public void testHelloSelenium() {
        // Launch (create an instance of) a web browser
        WebDriver driver = new ChromeDriver();

        // Navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        // Type username
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.sendKeys("standard_user");

        // Type password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click login button
        driver.findElement(By.id("login-button")).click();

        // Add product to cart
        addProductToCart(driver, "Sauce Labs Backpack");

        WebElement element = driver.findElement(new ByText("Sauce Labs Backpack"));

        // Verify title products in the landing page
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products");

        // Close the browser
        driver.quit();
    }

    private void addProductToCart(WebDriver driver, String productName) {
        String xpathButton = String.format("//div[text()='%s']/ancestor::div[@data-test='inventory-item']/descendant::button", productName);
        driver.findElement(By.xpath(xpathButton)).click();
    }
}
