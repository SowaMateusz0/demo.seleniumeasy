package Utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.v6.A;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GenericsMethods {

    WebDriver driver;

    public GenericsMethods(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectDropDown(WebElement dropDownMenu,String text){
        Select select = new Select(dropDownMenu);
        List<WebElement> options = select.getOptions();

        try {
            for (WebElement element1 : options) {
                if (element1.getText().equalsIgnoreCase(text)) {
                    select.selectByVisibleText(text);
                    break;
                }
            }
        } catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    public void multiSelectDropDown(WebElement element, List<String> list){

        Select select = new Select(element);
        List<WebElement> options = select.getOptions();

        for (String s : list) {
            for (WebElement el : options) {
                if (el.getText().equalsIgnoreCase(s)) {
                    select.selectByVisibleText(s);
                    break;
                }
            }
        }
    }
    
}
