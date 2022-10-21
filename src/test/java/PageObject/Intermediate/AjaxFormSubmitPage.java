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

    @FindBy(id = "title")
    @CacheLookup
    WebElement nameField;

    @FindBy(id = "description")
    @CacheLookup
    WebElement commentField;

    @FindBy(id = "btn-submit")
    @CacheLookup
    WebElement submitButton;

    @FindBy(id = "submit-control")
    @CacheLookup
    WebElement message;

    @FindBy(xpath = "//img[@src='\"LoaderIcon.gif\"']")
    @CacheLookup
    WebElement icon;

    public String getNameField() {
        return nameField.getAttribute("style");
    }

    public void enterName(String text) {
        nameField.sendKeys(text);
    }

    public void enterComment(String text) {
        commentField.sendKeys(text);
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public String getMessage() {
        waitForInvisibilityOfElement(driver,icon,5);
        return message.getText();
    }
}
