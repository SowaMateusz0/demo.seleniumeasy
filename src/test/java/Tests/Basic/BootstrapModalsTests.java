package Tests.Basic;

import PageObject.Basic.BootstrapModalsPage;
import PageObject.Basic.HomePage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BootstrapModalsTests extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void validateSingleModalExample(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,7);
        BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage(driver);

        bootstrapModalsPage.clickLaunchSingleModal();
        bootstrapModalsPage.clickSaveChangesSingleModal();
        Assert.assertFalse(bootstrapModalsPage.getSingleModalWindow().isDisplayed());
    }

    @Test
    public void validateMultiModalExample(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,7);
        BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage(driver);

        bootstrapModalsPage.clickLaunchMultiModal();
        bootstrapModalsPage.clickLaunchMultiModalFirstModal();
        bootstrapModalsPage.clickSaveChangesMultiSecondModal();
        Assert.assertFalse(bootstrapModalsPage.getMultiModalWindow().isDisplayed());
    }
}
