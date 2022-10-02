package PageObject;

import Assists.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
        return checkBoxMessage;
    }
    public void clickSingleCheckBox() {
        checkBoxMessage.click();
    }

    public String getMessageAfterClickCheckbox() {
        return messageAfterClickCheckbox.getText();
    }

    //*************Multiple Checkbox Demo*************
    public List<WebElement> getOptionsCheckboxes() {
        return optionsCheckboxes;
    }

    public void clickOptionsCheckboxes() {
        for (WebElement element: optionsCheckboxes) {
            element.click();
        }
    }

    public WebElement getCheckAllButton() {
        return checkAllButton;
    }

}
