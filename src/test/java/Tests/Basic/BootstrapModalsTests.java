package Tests.Basic;

import PageObject.Basic.BootstrapModalsPage;
import PageObject.Basic.HomePage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BootstrapModalsTests extends BaseClass {

    @Test
    public void validateSingleModalExample(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(7);
        BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage(driver);

        bootstrapModalsPage.clickLaunchSingleModal().clickSaveChangesSingleModal();
        Assert.assertFalse(bootstrapModalsPage.getSingleModalWindow().isDisplayed());
    }

    @Test
    public void validateMultiModalExample(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(7);
        BootstrapModalsPage bootstrapModalsPage = new BootstrapModalsPage(driver);

        bootstrapModalsPage.clickLaunchMultiModal().clickLaunchMultiModalFirstModal().clickSaveChangesMultiSecondModal();
        Assert.assertFalse(bootstrapModalsPage.getMultiModalWindow().isDisplayed());
    }
}
