package Tests.Basic;

import PageObject.Basic.HomePage;
import PageObject.Basic.JavascriptAlertsPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JavascriptAlertsTest extends BaseClass {

    @Test
    public void validateJavaScriptAlertBoxText(){

        final String ALTER_TEXT = "I am an alert box!";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(4);
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);

        javascriptAlertsPage.clickAlertClickMeButton();
        javascriptAlertsPage.AlertText(driver);
        Assert.assertEquals(javascriptAlertsPage.AlertText(driver),ALTER_TEXT);
        driver.switchTo().alert().accept();
    }

    @Test
    public void javaScriptConfirmBoxAccept(){


        final String TEXT_AFTER_ACCEPT_ALTER = "You pressed OK!";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(4);
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        javascriptAlertsPage.clickConfirmClickMeButton();
        driver.switchTo().alert().accept();
        Assert.assertEquals(javascriptAlertsPage.getMessageAfterConfirmBox(),TEXT_AFTER_ACCEPT_ALTER);
    }

    @Test
    public void javaScriptConfirmBoxDismiss(){

        final String TEXT_AFTER_ACCEPT_ALTER = "You pressed Cancel!";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(4);
        JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage(driver);
        javascriptAlertsPage.clickConfirmClickMeButton();
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(javascriptAlertsPage.getMessageAfterConfirmBox(),TEXT_AFTER_ACCEPT_ALTER);
    }

    @Test
    public void javaScriptAlertBoxEnterValue(){

        final String OUTPUT_TEXT= "You have entered 'Hello' !";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(4);
        JavascriptAlertsPage javascriptAlerts = new JavascriptAlertsPage(driver);

        javascriptAlerts.clickPromptBox();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();
        Assert.assertEquals(javascriptAlerts.getMessageAfterConfirmPromptBox(),OUTPUT_TEXT);
    }

}
