package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.WaitForElement.waitUntilElementIsClickable;
import static Utility.WaitForElement.waitUntilElementIsVisible;


public class BootstrapModalsPage {

    protected WebDriver driver;

    public BootstrapModalsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Single Modal Example*************
    @FindBy(xpath = "//a[@href='#myModal0']")
    @CacheLookup
    private WebElement launchSingleModal;

    @FindBy(xpath = "//div[@id='myModal0']//a[@onclick='history.go(0)']")
    @CacheLookup
    private WebElement saveChangesSingleModal;

    @FindBy(xpath = "//*[@id='myModal0']/div[@class='modal-dialog']")
    @CacheLookup
    private WebElement singleModalWindow;

    //*************Multi Modal Example*************
    @FindBy(xpath = "//a[@href='#myModal']")
    @CacheLookup
    private WebElement launchMultiModal;

    @FindBy(xpath = "//a[@href='#myModal2']")
    @CacheLookup
    private WebElement launchMultiModalFirstModal;

    @FindBy(xpath = "//div[@id='myModal2']//a[@onclick='history.go(0)']")
    @CacheLookup
    private WebElement saveChangesMultiSecondModal;

    @FindBy(xpath = "//*[@id='myModal']/div[@class='modal-dialog']")
    @CacheLookup
    private WebElement multiModalWindow;


    //*************Single Modal Example*************

    public BootstrapModalsPage clickLaunchSingleModal() {
        waitUntilElementIsClickable(launchSingleModal,driver);
        launchSingleModal.click();
        return this;
    }

    public BootstrapModalsPage clickSaveChangesSingleModal() {
        waitUntilElementIsClickable(saveChangesSingleModal,driver);
         saveChangesSingleModal.click();
         return this;
    }

    public WebElement getSingleModalWindow() {
        waitUntilElementIsVisible(singleModalWindow,driver);
        return singleModalWindow;
    }

    //*************Multi Modal Example*************
    public BootstrapModalsPage clickLaunchMultiModal() {
        waitUntilElementIsClickable(launchMultiModal,driver);
        launchMultiModal.click();
        return this;
    }

    public BootstrapModalsPage clickLaunchMultiModalFirstModal() {
        waitUntilElementIsClickable(launchMultiModalFirstModal,driver);
        launchMultiModalFirstModal.click();
        return this;
    }

    public BootstrapModalsPage clickSaveChangesMultiSecondModal() {
        waitUntilElementIsClickable(saveChangesMultiSecondModal,driver);
        saveChangesMultiSecondModal.click();
        return this;
    }

    public WebElement getMultiModalWindow() {
        waitUntilElementIsVisible(multiModalWindow,driver);
        return multiModalWindow;
    }

}
