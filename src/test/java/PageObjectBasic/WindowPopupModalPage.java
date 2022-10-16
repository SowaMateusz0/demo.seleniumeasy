package PageObjectBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    public void clickFollowOnTwitterButton(){
        followOnTwitterButton.click();
    }

    public void clickLikeUsOnFacebookButton(){
        likeUsOnFacebook.click();
    }

    public void clickFollowTwitterAndFacebook(){
        followTwitterAndFacebook.click();
    }
}
