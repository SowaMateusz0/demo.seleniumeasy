package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.GenericsMethods.getAlertText;
import static Utility.WaitForElement.waitUntilElementIsClickable;
import static Utility.WaitForElement.waitUntilElementIsVisible;

public class JavascriptAlertsPage{

    protected WebDriver driver;

    public JavascriptAlertsPage(WebDriver driver) {
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

    public JavascriptAlertsPage clickAlertClickMeButton(){
        waitUntilElementIsClickable(alertClickMeButton,driver);
        alertClickMeButton.click();
        return this;
    }

    public String AlertText(WebDriver driver){
        return getAlertText(driver);
    }

    public JavascriptAlertsPage clickConfirmClickMeButton(){
        waitUntilElementIsClickable(confirmClickMeButton,driver);
        confirmClickMeButton.click();
        return this;
    }

    public String getMessageAfterConfirmBox() {
        waitUntilElementIsVisible(messageAfterConfirmBox,driver);
        return messageAfterConfirmBox.getText();
    }

    public JavascriptAlertsPage clickPromptBox(){
        waitUntilElementIsClickable(clickForPromptBox,driver);
        clickForPromptBox.click();
        return this;
    }

    public String getMessageAfterConfirmPromptBox() {
        waitUntilElementIsVisible(messageAfterPromptBox,driver);
        return messageAfterPromptBox.getText();
    }
}
