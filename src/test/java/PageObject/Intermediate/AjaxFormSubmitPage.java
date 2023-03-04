package PageObject.Intermediate;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AjaxFormSubmitPage extends GenericsMethods {

    WebDriver driver;

    public AjaxFormSubmitPage(WebDriver driver) {
        super(driver);
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
        nameField.sendKeys(text);
        return this;
    }

    public AjaxFormSubmitPage enterComment(String text) {
        commentField.sendKeys(text);
        return this;
    }

    public AjaxFormSubmitPage clickSubmit(){
        submitButton.click();
        return this;
    }

    public String getMessage() {
        waitForInvisibilityOfElement(driver,icon,5);
        return message.getText();
    }
}
