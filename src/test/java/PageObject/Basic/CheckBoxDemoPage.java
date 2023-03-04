package PageObject.Basic;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.waits.WaitForElement.*;

public class CheckBoxDemoPage extends GenericsMethods {

    WebDriver driver;

    public CheckBoxDemoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Single Checkbox Demo*************
    @FindBy(id = "isAgeSelected")
    @CacheLookup
    private WebElement checkBoxMessage;

    @FindBy(id = "txtAge")
    @CacheLookup
    private WebElement messageAfterClickCheckbox;

    //*************Multiple Checkbox Demo*************
    @FindBy(xpath = "//input[@class='cb1-element']")
    @CacheLookup
    private List<WebElement> optionsCheckboxes;

    @FindBy(id = "check1")
    @CacheLookup
    private WebElement checkAllButton;




    //*************Single Checkbox Demo*************
    public WebElement getSingleCheckBox() {
        waitUntilElementIsVisible(checkAllButton,driver);
        return checkBoxMessage;
    }
    public CheckBoxDemoPage clickSingleCheckBox() {
        waitUntilElementIsClickable(checkBoxMessage,driver);
        checkBoxMessage.click();
        return this;
    }

    public String getMessageAfterClickCheckbox() {
        waitUntilElementIsVisible(messageAfterClickCheckbox,driver);
        return messageAfterClickCheckbox.getText();
    }

    //*************Multiple Checkbox Demo*************
    public List<WebElement> getOptionsCheckboxes() {
        waitUntilAllElementsAreVisible(optionsCheckboxes,driver);
        return optionsCheckboxes;
    }

    public WebElement clickOptionsCheckbox(int index) {
        waitUntilElementIsVisible(optionsCheckboxes.get(index),driver);
        return optionsCheckboxes.get(index);
    }

    public WebElement getCheckAllButton() {
        waitUntilElementIsClickable(checkAllButton,driver);
        return checkAllButton;
    }
    public CheckBoxDemoPage clickCheckAllButton() {
        waitUntilElementIsClickable(checkAllButton,driver);
        checkAllButton.click();
        return this;
    }

}
