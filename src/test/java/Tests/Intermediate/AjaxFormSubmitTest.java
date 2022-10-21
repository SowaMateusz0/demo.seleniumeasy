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

        String expectedText = "Form submited Successfully!";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,1);
        AjaxFormSubmitPage ajaxFormSubmitPage = new AjaxFormSubmitPage(driver);

        ajaxFormSubmitPage.enterName("Mateusz");
        ajaxFormSubmitPage.enterComment("Sowa");
        ajaxFormSubmitPage.clickSubmit();

        Assert.assertEquals(ajaxFormSubmitPage.getMessage(),expectedText);


    }

}
