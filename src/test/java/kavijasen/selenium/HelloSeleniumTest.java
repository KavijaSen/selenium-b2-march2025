package kavijasen.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HelloSeleniumTest {


    @Test
    public void testHelloSelenium(){

        //Launch (create an instance of) a web browser
        WebDriver driver = new ChromeDriver();

        //navigate to the sauce login page
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        //Type username
        WebElement txtUsername = driver.findElement(By.id("user-name"));
        txtUsername.sendKeys("standard_user");

        //Type password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //click login button
        driver.findElement(By.id("login-button")).click();

        //verify title products in the landing page
        Assert.assertEquals(driver.findElement(By.cssSelector(".title")).getText(), "Products");

        //close the browser
        driver.quit();



    }


}
