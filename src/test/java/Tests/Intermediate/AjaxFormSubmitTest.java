package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.AjaxFormSubmitPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AjaxFormSubmitTest extends BaseClass {

    @Test
    public void ValidateAjaxFormSubmitWithoutInputAnyValue() throws InterruptedException {

        final String EXPECTED_TEXT = "Form submited Successfully!";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE).chooseBasicExample(1);
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage(driver);

        ajaxFormSubmitPage.enterName("Mateusz").enterComment("Sowa").clickSubmit();

        Assert.assertEquals(ajaxFormSubmitPage.getMessage(),EXPECTED_TEXT);


    }

}
