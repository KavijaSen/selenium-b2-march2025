package kavijasen.selenium.pages;

import kavijasen.selenium.util.ActionBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private ActionBot actionBot;

    //Define elements with By (Web elements)
    private final By byUsername = By.id ("user-name");
    private final By byPassword = By.id("password");
    private final By byLoginButton = By.id("login-button");
    private final By byError = By.cssSelector("h3[data-test='error']");


    public LoginPage(WebDriver driver) {    //Constructor
        this.driver = driver;
        actionBot = new ActionBot(driver);
    }

    public LoginPage typeUsername (String username){
        driver.findElement(byUsername).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(byPassword).sendKeys(password);
        return this;
    }

    public void clickLogin() {
       // driver.findElement(byLoginButton).click();
        actionBot.waitAndClick(byLoginButton);
    }

    public String getError() {
        return driver.findElement(byError).getText();
    }
}
