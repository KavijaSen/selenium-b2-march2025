package kavijasen.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import kavijasen.selenium.util.ActionBot;

public class CheckoutCompletePage {

    private final WebDriver driver;
    private final ActionBot actionBot;

    // "Thank you for your order!" message
    private final By completeHeader = By.cssSelector("h2.complete-header[data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver, ActionBot actionBot) {
        this.driver = driver;
        this.actionBot = actionBot;
    }

    // Method for order completion message
    public boolean isOrderCompleteMessageDisplayed() {
        return driver.findElement(completeHeader).isDisplayed();
    }

    // Check for the text of the completion message
    public String getOrderCompleteMessage() {
        return driver.findElement(completeHeader).getText();
    }

    // Get the current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
