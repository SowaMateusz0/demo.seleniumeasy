package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.List;


public class GenericsMethods {

    WebDriver driver;

    public GenericsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public static void selectDropDown(WebElement dropDownMenu,String text){
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

    public static String getAlertText(WebDriver driver){
       return driver.switchTo().alert().getText();
    }


}
