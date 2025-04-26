package kavijasen.selenium.Examples;
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
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }



    /**Method to enter username & password**/
    public  void enterCredentials (String userName, String password)
    {
        WebElement usernameInput=driver.findElement(By.id("user-name"));
        WebElement passwordInput=driver.findElement(By.id("password"));

        usernameInput.clear();
        usernameInput.sendKeys(userName);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(By.id("login-button")).click();
    }



    private String getErrorMessage() {
        return driver.findElement(By.cssSelector("[data-test='error']")).getText();
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
        driver.findElement(By.id("password")).sendKeys("Invalid");
        driver.findElement(By.id("login-button")).click();

        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service","Login Failed: Unexpected error message");
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

    /**Test with blank username, correct password**/
    @Test
    public void testBlankUsername()
    {
        enterCredentials("","secret_sauce");
        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Login Failed: Unexpected error message");

    }

    /**Test with Invalid username correct password**/
    @Test
    public void testInvalidUsername()
    {
        enterCredentials("User1","secret_sauce");
        String errorMessage= getErrorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service","Login Failed: Unexpected error message");
    }

    /**Test with invalid username & invalid password**/
    @Test
    public void testInvalidNamePswrd()
    {
        enterCredentials("User", "password");
        String errorMessage = getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Login Failed: Unexpected error message");
    }

    /**Test with correct username blank password**/
    @Test
    public void testBlankPassword()
    {
        enterCredentials("standard_user","");
        String errorMessage=getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Password is required","Login Failed: Unexpected error message" );
    }

    /**Test with blank username & password**/
    @Test
    public void blankUsernamePswrd()
    {
        enterCredentials("","");
        String errorMessage=getErrorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username is required","Login Failed: Unexpected error message");
    }

    /**Special characters in username/password**/
    @Test
    public void charactersUnamePswrd()
    {
        enterCredentials("user@1223!","password@#1");
        String errorMessage=getErrorMessage();
        Assert.assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service", "Login Failed: Unexpected error message");
    }

    /**Long password & username**/
    @Test
    public void longUnamePswrd()
    {
        enterCredentials("User123SeneviratneKavija","passwordKavijaSeneviratne123");
        String errorMessage=getErrorMessage();
        Assert.assertEquals(errorMessage,"Epic sadface: Username and password do not match any user in this service", "Login Failed: Unexpected error message");

    }

}
