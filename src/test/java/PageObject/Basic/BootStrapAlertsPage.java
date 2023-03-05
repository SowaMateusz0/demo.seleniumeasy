package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.WaitForElement.*;

public class BootStrapAlertsPage {

    protected WebDriver driver;

    public BootStrapAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Bootstrap Alert messages*************

    @FindBy(xpath = "//button[contains(@id,'normal')]")
    @CacheLookup
    private List<WebElement> normalMessages;

    @FindBy(xpath = "//button[contains(@id,'autoclosable')]")
    @CacheLookup
    private List<WebElement> autocloseableMessages;

    @FindBy(xpath = "//div[contains(@class,'alert-normal')]")
    @CacheLookup
    private List<WebElement> normalAlertsMessage;

    @FindBy(xpath = "//div[contains(@class,'alert-autocloseable')]")
    @CacheLookup
    private List<WebElement> autocloseableAlertsMessage;

    public List<WebElement> getNormalAlertsMessage() {
        waitUntilAllElementsAreVisible(normalAlertsMessage,driver);
        return normalAlertsMessage;
    }

    public List<WebElement> getNormalMessagesList(){
        waitUntilAllElementsAreVisible(normalMessages,driver);
        return normalMessages;
    }

    public BootStrapAlertsPage openNormalMessages(){
        for (WebElement element: normalMessages) {
            waitUntilElementIsClickable(element,driver);
            element.click();
        }
        return this;
    }

    public List<WebElement> getAutocloseableMessagesList() {
        waitUntilAllElementsAreVisible(autocloseableAlertsMessage,driver);
        return autocloseableAlertsMessage;
    }

    public List<WebElement> getAutocloseableListButtons() {
        waitUntilAllElementsAreVisible(autocloseableAlertsMessage,driver);
        return autocloseableMessages;
    }
}
