package kavijasen.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import kavijasen.selenium.util.ActionBot;

public class CheckoutPage {

    private final WebDriver driver;
    private final ActionBot actionBot;

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver, ActionBot actionBot) {
        this.driver = driver;
        this.actionBot = actionBot;
    }


    public void enterFirstName(String firstName) {
        actionBot.clearAndType(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        actionBot.clearAndType(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode) {
        actionBot.clearAndType(postalCodeField, postalCode);
    }

    public void clickContinue() {
        actionBot.waitAndClick(continueButton);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
