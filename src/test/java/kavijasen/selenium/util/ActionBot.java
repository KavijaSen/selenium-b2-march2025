package kavijasen.selenium.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//A utility class that encapsulates common Selenium WebDriver actions with built-in explicit waits.
public class ActionBot {
    private final WebDriver driver;
    private final WebDriverWait wait;

// Constructs an ActionBot instance with the given WebDriver.
// @param driver The WebDriver instance to use for interacting with the browser.
    public ActionBot (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


 // Waits until the element located by the given By locator is clickable and then clicks it.
//@param by The By locator used to identify the element.
    public void waitAndClick (By by){
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }


// Clears the text content of the element located by the given By locator.
// @param by The By locator used to identify the element.
    public void clear(By by){
        driver.findElement(by).clear();
    }



// @param by The By locator used to identify the element.
// @param inputText The text to type into the elemen
    public void type(By by, String inputText){
        driver.findElement(by).sendKeys(inputText);
    }


//Clears the text content of the element located by the given By locator and then types the given input text.
//@param by      The By locator used to identify the element.
//@param inputText The text to type into the element after clearing.

    public void clearAndType (By by, String inputText){
        clear (by);
        type(by, inputText);
    }

}
