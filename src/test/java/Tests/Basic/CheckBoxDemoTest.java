package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.Basic.CheckBoxDemoPage;
import PageObject.Basic.HomePage;
import Tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckBoxDemoTest extends BaseClass {

    @Test
    public void singleCheckboxDemo(){

        final String MESSAGE = "Success - Check box is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);

        checkBoxDemoPage.clickSingleCheckBox();
        Assert.assertEquals(checkBoxDemoPage.getMessageAfterClickCheckbox(),MESSAGE);
        Assert.assertTrue(checkBoxDemoPage.getSingleCheckBox().isSelected());
    }

    @Test
    public void isCheckboxSelected(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);


        for (int i = 0; i < checkBoxDemoPage.getOptionsCheckboxes().size(); i++) {
            checkBoxDemoPage.clickOptionsCheckbox(i).click();
            Assert.assertTrue(checkBoxDemoPage.clickOptionsCheckbox(i).isSelected());
        }
    }

    @Test
    public void multipleCheckboxDemoValidateResultOfCheckAllCheckboxes(){

        final String MESSAGE_WITH_ALL_CHECKED_CHECKBOXES = "Uncheck All";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);

        checkBoxDemoPage.clickCheckAllButton();
        Assert.assertEquals(checkBoxDemoPage.getCheckAllButton().getAttribute("value"),MESSAGE_WITH_ALL_CHECKED_CHECKBOXES);
    }

    @Test
    public void uncheckOneCheckboxAndValidateBoxText(){

        final String MESSAGE_WITH_ONE_UNCHECKED_CHECKBOX = "Check All";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(1);
        CheckBoxDemoPage checkBoxDemoPage = new CheckBoxDemoPage(driver);
        checkBoxDemoPage.clickOptionsCheckbox(1);
        Assert.assertEquals(checkBoxDemoPage.getCheckAllButton().getAttribute("value"),MESSAGE_WITH_ONE_UNCHECKED_CHECKBOX);
    }

}
