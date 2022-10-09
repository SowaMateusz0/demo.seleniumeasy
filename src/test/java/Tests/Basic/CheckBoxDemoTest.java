package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.CheckBoxDemoPage;
import PageObject.HomePage;
import Tests.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        final String message = "Success - Check box is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);

        checkBoxDemoPage.clickSingleCheckBox();
        Assert.assertEquals(checkBoxDemoPage.getMessageAfterClickCheckbox(),message);
        Assert.assertTrue(checkBoxDemoPage.getSingleCheckBox().isSelected());
    }

    @Test
    public void isCheckboxSelected(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);


        for (int i = 0; i < checkBoxDemoPage.getOptionsCheckboxes().size(); i++) {
            checkBoxDemoPage.clickOptionsCheckbox(i).click();
            Assert.assertTrue(checkBoxDemoPage.clickOptionsCheckbox(i).isSelected());
        }
    }

    @Test
    public void multipleCheckboxDemoValidateResultOfCheckAllCheckboxes(){

        final String messageWithAllCheckedCheckboxes = "Uncheck All";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);

        checkBoxDemoPage.clickCheckAllButton();
        Assert.assertEquals(checkBoxDemoPage.getCheckAllButton().getAttribute("value"),messageWithAllCheckedCheckboxes);
    }

    @Test
    public void uncheckOneCheckboxAndValidateBoxText(){

        final String messageWithOneUncheckedCheckboxes = "Check All";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);
        checkBoxDemoPage.clickOptionsCheckbox(1);
        Assert.assertEquals(checkBoxDemoPage.getCheckAllButton().getAttribute("value"),messageWithOneUncheckedCheckboxes);
    }

}
