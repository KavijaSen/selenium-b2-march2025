package SelectItems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


public class SelectItemsDropDownExampleTest {

    WebDriver driver;

        @BeforeMethod
        public void beforeMethod()
        {
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://pragmatictesters.github.io/selenium-webdriver-examples/dropdowns.html");
        }


        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

        @Test
    public void testSingleSelect()
        {
            WebElement eleSelect = driver.findElement(By.id("singleSelect"));

            Select selFruits = new Select(eleSelect);
            Assert.assertEquals(selFruits.getFirstSelectedOption().getText(),"Select a fruit");

            List<WebElement> options = selFruits.getOptions();
            for (WebElement option: options){
                System.out.println(option.getText());
            }

            //Select item by visible text
            selFruits.selectByVisibleText("Apple");
            Assert.assertEquals(selFruits.getFirstSelectedOption().getText(),"Apple");

            //Select item by value
            selFruits.selectByValue("banana");
            Assert.assertEquals(selFruits.getFirstSelectedOption().getText(),"Banana");

            //Select item by index
            selFruits.selectByIndex(4);
            Assert.assertEquals(selFruits.getFirstSelectedOption().getText(),"Date");
        }

        @Test
        public void testMultiSelect(){

            WebElement multiselect = driver.findElement(By.id("multiSelect"));

            Select selColour = new Select(multiselect);


            selColour.selectByIndex(2);
            selColour.selectByValue("red");
            selColour.selectByVisibleText("Green");

            selColour.deselectByIndex(2);
            selColour.deselectAll();

            // Retrieving selected options-Can use if needed. After retrieving, you can use assertions to see
            //whether the selection is correct
            List<WebElement> selectedOptions = selColour.getAllSelectedOptions();

        }


    }
