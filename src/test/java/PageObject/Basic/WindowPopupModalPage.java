package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.waits.WaitForElement.waitUntilElementIsClickable;
import static Utility.waits.WaitForElement.waitUntilElementIsVisible;

public class WindowPopupModalPage {

    WebDriver driver;

    public WindowPopupModalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Single Window Popup*************

    @FindBy(xpath = "//a[@title='Follow @seleniumeasy on Twitter']")
    @CacheLookup
    private WebElement followOnTwitterButton;

    @FindBy(xpath = "//a[@title='Follow @seleniumeasy on Facebook']")
    @CacheLookup
    private WebElement likeUsOnFacebook;

    //*************Multiple Window Popup*************

    @FindBy(xpath = "//a[text()='Follow Twitter & Facebook']")
    @CacheLookup
    private WebElement followTwitterAndFacebook;

    @FindBy(id = "followall")
    @CacheLookup
    private WebElement followAll;



    public WindowPopupModalPage clickFollowOnTwitterButton(){
        waitUntilElementIsClickable(followOnTwitterButton,driver);
        followOnTwitterButton.click();
        return this;
    }

    public WindowPopupModalPage clickLikeUsOnFacebookButton(){
        waitUntilElementIsClickable(likeUsOnFacebook,driver);
        likeUsOnFacebook.click();
        return this;
    }

    public WindowPopupModalPage clickFollowTwitterAndFacebook(){
        waitUntilElementIsClickable(followTwitterAndFacebook,driver);
        followTwitterAndFacebook.click();
        return this;
    }
}
