package PageObject.Intermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.WaitForElement.*;

public class AjaxFormSubmitPage {

    protected WebDriver driver;

    public AjaxFormSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Ajax Form*************

    @FindBy(id = "title")
    @CacheLookup
    private WebElement nameField;

    @FindBy(id = "description")
    @CacheLookup
    private WebElement commentField;

    @FindBy(id = "btn-submit")
    @CacheLookup
    private WebElement submitButton;

    @FindBy(id = "submit-control")
    @CacheLookup
    private WebElement message;

    @FindBy(xpath = "//img[@src='\"LoaderIcon.gif\"']")
    @CacheLookup
    private WebElement icon;

    //*************Ajax Form*************

    public AjaxFormSubmitPage enterName(String text) {
        waitUntilElementIsVisible(nameField,driver);
        nameField.sendKeys(text);
        return this;
    }

    public AjaxFormSubmitPage enterComment(String text) {
        waitUntilElementIsVisible(commentField,driver);
        commentField.sendKeys(text);
        return this;
    }

    public AjaxFormSubmitPage clickSubmit(){
        waitUntilElementIsClickable(submitButton,driver);
        submitButton.click();
        return this;
    }

    public String getMessage() {
        waitForInvisibilityOfElement(message,driver);
        return message.getText();
    }
}
