package Tests.Basic;

import Assists.DifficultyOfExercises;
import PageObject.CheckBoxDemoPage;
import PageObject.HomePage;
import PageObject.SimpleFormDemoPage;
import Tests.BaseClass;
import Tests.HomePageTests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckBoxDemoTest extends BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void singleCheckboxDemo(){

        final String message= "Success - Check box is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);

        checkBoxDemoPage.clickSingleCheckBox();
        Assert.assertEquals(checkBoxDemoPage.getMessageAfterClickCheckbox(),message);
        Assert.assertTrue(checkBoxDemoPage.getSingleCheckBox().isSelected());
    }

}
