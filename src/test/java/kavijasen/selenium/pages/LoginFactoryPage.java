package kavijasen.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactoryPage {
    private final WebDriver driver;

    //Elements definitions
    @FindBy(id="user-name")
    WebElement eleUsername;

    @FindBy(id="password")
    WebElement elePassword;

    @FindBy(id="login-button")
    WebElement eleLoginButton;

    @FindBy (css= "h3[data-test='error']")
    WebElement eleError;

    //Constructor
    public LoginFactoryPage(WebDriver driver) {
        this.driver = driver;

        //Init Elements
        PageFactory.initElements(driver, this);

    }

    public LoginFactoryPage typeUsername(String username) {
        eleUsername.sendKeys(username);
        return this;
    }


    public LoginFactoryPage typePassword(String password) {
        elePassword.sendKeys(password);
        return this;
    }

    public void clickLogin() {
        eleLoginButton.click();
    }

    public String getError() {
        return eleError.getText();
    }
}
