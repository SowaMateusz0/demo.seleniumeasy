package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BootstrapModalsPage {

    WebDriver driver;

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

    public void clickLaunchSingleModal() {
        launchSingleModal.click();
    }

    public void clickSaveChangesSingleModal() {
         saveChangesSingleModal.click();
    }

    public WebElement getSingleModalWindow() {
        return singleModalWindow;
    }

    //*************Multi Modal Example*************
    public void clickLaunchMultiModal() {
        launchMultiModal.click();
    }

    public void clickLaunchMultiModalFirstModal() {
        launchMultiModalFirstModal.click();
    }

    public void clickSaveChangesMultiSecondModal() {
        saveChangesMultiSecondModal.click();
    }

    public WebElement getMultiModalWindow() {
        return multiModalWindow;
    }

}
