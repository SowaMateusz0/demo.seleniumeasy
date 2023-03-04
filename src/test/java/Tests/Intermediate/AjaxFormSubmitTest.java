package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.AjaxFormSubmitPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AjaxFormSubmitTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

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
