package kavijasen.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Waits () {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pragmatictesters.github.io/selenium-synchronization/buttons.html");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testImplicitWait () throws InterruptedException{
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("easyoo")).click();
        driver.findElement(By.id("easy01")).click();
        driver.findElement(By.id("easy02")).click();
        driver.findElement(By.id("easy03")).click();

        Assert.assertEquals(driver.findElement(By.id("easybuttonmessage")).getText(), "All Buttons Clicked");
        //Assert.assertEquals(actual, expected);

    }

    @Test
    public void testExplicitWait() throws InterruptedException{
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy00"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy01"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy02"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("easy03"))).click();

        //Refer https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/ui/ExpectedConditions.html

        String message = driver.findElement(By.id("easybuttonmessage")).getText();
        Assert.assertEquals(message, "All Buttons Clicked");

    }

    public void testFluentWait() throws InterruptedException
    {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .withMessage("Element is not visible within the timeout period")
                .ignoring(ElementNotInteractableException.class)
                .pollingEvery(Duration.ofMillis(100));

        // Wait for the "Start" button to be clickable and click it
        log("Waiting for the 'Start' button to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button00"))).click();

        // Wait for the "One" button to be clickable and click it
        log("Waiting for the 'One' button to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button01"))).click();

        // Wait for the "Two" button to be clickable and click it
        log("Waiting for the 'Two' button to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button02"))).click();

        // Wait for the "Three" button to be clickable and click it
        log("Waiting for the 'Three' button to be clickable...");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button03"))).click();

        // Verify that the message "All Buttons Clicked" is displayed
        log("Verifying the final message...");
        wait.until(ExpectedConditions.textToBe(By.id("buttonmessage"), "All Buttons Clicked"));
        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "All Buttons Clicked");

        // Verify that the message "Click Buttons In Order" is displayed
        log("Verifying the message reset...");
        wait.until(ExpectedConditions.textToBe(By.id("buttonmessage"), "Click Buttons In Order"));
        Assert.assertEquals(driver.findElement(By.id("buttonmessage")).getText(), "Click Buttons In Order");


    }

    private void log(String message) {
        System.out.println("[INFO] " + message);
    }

}
