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

    /**Test with valid credentials**/
    @Test
    public void testLoginWithValidCredentials()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

    }

    /**Test with valid username & invalid password**/
    @Test
    public void testLoginWithInvalidPassword()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement((By.id("password")).sendKeys("Invalid"));
        driver.findElement(By.id("login-button")).click();

        String actualTitle = getPageTitle();
        Assert.assertEquals(actualTitle, "Products", "Login Failed: Unexpected page Title");
    }

    /**Test with locked out user**/
    @Test
    public void testLockedOutUser()
    {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.", "Login Failed: Unexpected error message");
    }

    /**Test with blank username**/
    @Test
    public void testBlankUsername()
    {
        enterCredentials("","secret_sauce");

    }


}
