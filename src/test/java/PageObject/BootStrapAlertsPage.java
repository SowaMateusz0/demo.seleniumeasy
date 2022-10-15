package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BootStrapAlertsPage {

    WebDriver driver;

    public BootStrapAlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Bootstrap Alert messages*************

    @FindBy(xpath = "//button[contains(@id,'normal')]")
    List<WebElement> normalMessages;

    @FindBy(xpath = "//button[contains(@id,'autoclosable')]")
    List<WebElement> autocloseableMessages;

    @FindBy(xpath = "//div[contains(@class,'alert-normal')]")
    List<WebElement> normalAlertsMessage;

    @FindBy(xpath = "//div[contains(@class,'alert-autocloseable')]")
    List<WebElement> autocloseableAlertsMessage;

    public List<WebElement> getNormalAlertsMessage() {
        return normalAlertsMessage;
    }

    public List<WebElement> getNormalMessagesList(){
        return normalMessages;
    }

    public void openNormalMessages(){
        for (WebElement element: normalMessages) {
            element.click();
        }
    }

    public List<WebElement> getAutocloseableMessagesList() {
        return autocloseableAlertsMessage;
    }

    public void openAutocloseableMessages(){
        for (WebElement element: autocloseableMessages) {
            element.click();
        }
    }

    public List<WebElement> getAutocloseableListButtons() {
        return autocloseableMessages;
    }
}
