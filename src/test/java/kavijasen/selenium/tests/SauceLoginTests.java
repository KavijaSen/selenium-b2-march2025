package kavijasen.selenium.tests;

import kavijasen.selenium.pages.InventoryPage;
import kavijasen.selenium.pages.LoginFactoryPage;
import kavijasen.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceLoginTests {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void testLoginWithInvalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typeUsername("invalid").clickLogin();
        assertEquals(loginPage.getError()
                ,"Epic sadface: Username and password do not match",
                "Error for invalid password is incorrect");
    }

    @Test
    public void testLoginWithInvalidPasswordFactory(){
        LoginFactoryPage loginPage = new LoginFactoryPage(driver);
        loginPage.typeUsername("standard_user").typePassword("invalid").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match",
                "Error for invalid password is incorrect");
    }


    @Test
    public void testLoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typeUsername("secret_sauce").clickLogin();

        InventoryPage inventoryPage=new InventoryPage(driver);
        assertEquals(inventoryPage.getTitle(),"Products","Inventory Page Title test failed");
    }

}


