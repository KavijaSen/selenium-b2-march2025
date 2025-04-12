package kavijasen.selenium.tests;

import kavijasen.selenium.pages.CheckoutCompletePage;
import kavijasen.selenium.util.ActionBot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CheckoutCompleteTest {

    private WebDriver driver;
    private CheckoutCompletePage checkoutCompletePage;
    private ActionBot actionBot;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        actionBot = new ActionBot(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver, actionBot);
    }

    @Test
    public void testOrderCompleteMessage() {
        // Verify "Thank you for your order!"
        assertTrue(checkoutCompletePage.isOrderCompleteMessageDisplayed(), "Order completion message not displayed.");
    }

    @Test
    public void testOrderCompleteMessageText() {
        // Verify the exact text in the order completion
        String expectedMessage = "Thank you for your order!";
        assertEquals(checkoutCompletePage.getOrderCompleteMessage(), expectedMessage, "Order complete message text is incorrect.");
    }

    @Test
    public void testRedirectedToCorrectPageAfterOrder() {
        // Check that the current URL matches the expected URL after successful order completion
        String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";
        assertEquals(checkoutCompletePage.getCurrentUrl(), expectedUrl, "The URL did not match after checkout.");
    }
}
