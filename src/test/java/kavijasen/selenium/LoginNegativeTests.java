package kavijasen.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginNegativeTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod()
    {
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }

    @Test
    public void testLoginWithValidCredentials()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

}
