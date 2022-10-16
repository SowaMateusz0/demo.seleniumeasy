package PageObjectBasic;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertsPage extends GenericsMethods {


    WebDriver driver;

    public JavascriptAlertsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Java Script Alert Box 1*************

    @FindBy(xpath = "//button[@class='btn btn-default']")
    @CacheLookup
    private WebElement alertClickMeButton;

    //*************Java Script Confirm Box*************

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg' and text()='Click me!']")
    @CacheLookup
    private WebElement confirmClickMeButton;

    @FindBy(id = "confirm-demo")
    @CacheLookup
    private WebElement messageAfterConfirmBox;

    //*************Java Script Alert Box 2*************

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg' and text()='Click for Prompt Box']")
    @CacheLookup
    private WebElement clickForPromptBox;

    @FindBy(id = "prompt-demo")
    @CacheLookup
    private WebElement messageAfterPromptBox;

    public void clickAlertClickMeButton(){
        alertClickMeButton.click();
    }

    public String AlertText(WebDriver driver){
        return getAlertText(driver);
    }

    public void clickConfirmClickMeButton(){
        confirmClickMeButton.click();
    }

    public String getMessageAfterConfirmBox() {
        return messageAfterConfirmBox.getText();
    }

    public void clickPromptBox(){
        clickForPromptBox.click();
    }

    public String getMessageAfterConfirmPromptBox() {
        return messageAfterPromptBox.getText();
    }
}
