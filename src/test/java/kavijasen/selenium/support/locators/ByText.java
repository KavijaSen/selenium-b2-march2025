package kavijasen.selenium.support.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByText extends By {

    private final String visibleText;

    public ByText(String visibleText){
        this.visibleText=visibleText;
    }


    @Override
    public List<WebElement> findElements(SearchContext driver) {
        String xpath = String.format ("//*[text()='%s']", visibleText);
        return driver.findElements(By.xpath(xpath));
    }
}

