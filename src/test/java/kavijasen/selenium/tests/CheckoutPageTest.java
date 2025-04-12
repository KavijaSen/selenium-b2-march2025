package kavijasen.selenium.tests;

import kavijasen.selenium.pages.CheckoutPage;
import kavijasen.selenium.util.ActionBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CheckoutPageTest {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private ActionBot actionBot;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actionBot = new ActionBot(driver);
        checkoutPage = new CheckoutPage(driver, actionBot);
    }

    @Test
    public void testEnterValidCheckoutDetailsAndContinue() {
        checkoutPage.enterFirstName("Kavija");
        checkoutPage.enterLastName("Sen");
        checkoutPage.enterPostalCode("5000");
        checkoutPage.clickContinue();

        String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
        assertEquals(checkoutPage.getCurrentUrl(), expectedUrl, "Failed to navigate to checkout step two.");
    }

    @Test
    public void testMissingAllFieldsShouldNotProceed() {
        checkoutPage.clickContinue();

        String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
        assertEquals(checkoutPage.getCurrentUrl(), expectedUrl, "Should stay on step one when all fields are empty.");
    }

    @Test
    public void testOnlyFirstNameEntered() {
        checkoutPage.enterFirstName("Kavi");
        checkoutPage.clickContinue();

        assertEquals(checkoutPage.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Should stay on step one if other fields are missing.");
    }

    @Test
    public void testOnlyPostalCodeEntered() {
        checkoutPage.enterPostalCode("5000");
        checkoutPage.clickContinue();

        assertEquals(checkoutPage.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Should stay on step one if name fields are missing.");
    }

}


