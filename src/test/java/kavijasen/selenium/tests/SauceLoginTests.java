package kavijasen.selenium.tests;

import kavijasen.selenium.pages.InventoryPage;
import kavijasen.selenium.pages.LoginFactoryPage;
import kavijasen.selenium.pages.LoginPage;
import kavijasen.selenium.util.ActionBot;
import kavijasen.selenium.util.BrowserFactory;
import kavijasen.selenium.util.ConfigureReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.testng.annotations.*;

public class SauceLoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ActionBot actionBot;

    //private final Logger logger = LogManager.getLogger(SauceLoginTest.class); (Add SauceLogin.class)

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        BrowserFactory.init(browser);
        driver = BrowserFactory.getDriver();
        driver.get(ConfigureReader.getBaseURL());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test
    //   public void testLoginWithInvalidPassword(){
    //      LoginPage loginPage = new LoginPage(driver);
    //     loginPage.typeUsername("standard_user").typePassword("invalid").clickLogin();
    //    assertEquals(loginPage.getError()
    //            ,"Epic sadface: Username and password do not match",
    //             "Error for invalid password is incorrect");
    //  }


    //   @Test
    //  public void testLoginWithInvalidPasswordFactory(){
    //     LoginFactoryPage loginPage = new LoginFactoryPage(driver);
    //     loginPage.typeUsername("standard_user").typePassword("invalid").clickLogin();
    //    assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match",
    //              "Error for invalid password is incorrect");
    //  }

    //Login with valid credentials


    @Test
    public void testValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("secret_sauce").clickLogin();

        InventoryPage inventoryPage=new InventoryPage(driver);
        assertEquals(inventoryPage.getTitle(),"Products","Inventory Page Title test failed");
    }



    @Test
    public void testLoginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("invalid_user").typePassword("secret_sauce").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Username and password do not match any user in this service",
                "Error for invalid username is incorrect");
    }

    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("invalid").clickLogin();
        assertEquals(loginPage.getError()
                ,"Epic sadface: Username and password do not match any user in this service",
                "Error for invalid password is incorrect");
    }

    @Test
    public void testLoginWithEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("").typePassword("secret_sauce").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Username is required",
                "Error for empty username is incorrect");
    }

    @Test
    public void testLoginWithEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user").typePassword("").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Password is required",
                "Error for empty password is incorrect");
    }

    @Test
    public void testLoginWithEmptyCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("").typePassword("").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Username is required",
                "Error for empty credentials is incorrect");
    }

    @Test
    public void testLoginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("locked_out_user").typePassword("secret_sauce").clickLogin();
        assertEquals(loginPage.getError(), "Epic sadface: Sorry, this user has been locked out.",
                "Error for locked out user is incorrect");
    }

}




