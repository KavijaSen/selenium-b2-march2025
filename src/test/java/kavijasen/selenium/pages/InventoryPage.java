package kavijasen.selenium.pages;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import org.openqa.selenium.WebElement;


public class InventoryPage {
    private final WebDriver driver;

    private final By byTitle = By.cssSelector(".title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getTitle() {
        return driver.findElement(byTitle).getText();
    }

    //Pass the product name-look for the product name by text
    //  private void addProductToCart(String productName) {
     //   String xpathButton = String.format("//div[text()='%s']/ancestor::div[@data-test='inventory-item']/descendant::button", productName);
      //  driver.findElement(By.xpath(xpathButton)).click();
    //}

    public List<WebElement> getAllProductNames() {
        return driver.findElements(By.cssSelector(".inventory_item_name"));
    }

    public void addProductToCart(WebElement productElement) {
        WebElement parent = productElement.findElement(By.xpath("./ancestor::div[@data-test='inventory-item']"));
        WebElement button = parent.findElement(By.tagName("button"));
        button.click();
    }

    // Randomly add N products to cart
    public void addRandomProductsToCart(int count) {
        List<WebElement> allProducts = getAllProductNames();

        Random rand = new Random();
        for (int i = 0; i < count && !allProducts.isEmpty(); i++) {
            int index = rand.nextInt(allProducts.size());
            WebElement product = allProducts.get(index);
            addProductToCart(product);
            allProducts.remove(index); // avoid duplicate selection
        }

    }

    // Remove product from cart
    public void removeProductFromCart(String productName) {
        String removeButtonXpath = String.format("//div[text()='%s']/ancestor::div[@data-test='inventory-item']//button[@class='btn_inventory']",
                productName);
        WebElement removeButton = driver.findElement(By.xpath(removeButtonXpath));
        removeButton.click();
    }


}
