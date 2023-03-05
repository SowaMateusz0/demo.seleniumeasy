package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.Basic.HomePage;
import PageObject.Basic.RadioButtonsDemoPage;
import Tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RadioButtonsDemoTest extends BaseClass {

    @Test
    public void ValidateButtonTextAfterChoseFemaleRadioBox(){

        final String RADIO_BUTTON_VALUE  ="Radio button 'Female' is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.clickFemaleButton().getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),RADIO_BUTTON_VALUE);
    }

    @Test
    public void ValidateButtonTextAfterChoseMaleRadioBox(){

        String RADIO_BUTTON_VALUE  ="Radio button 'Male' is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.clickMaleButton().getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),RADIO_BUTTON_VALUE);
    }

    @Test
    public void ValidateButtonTextAWithoutCheckingAnyRadioButtons(){

        String RADIO_BUTTON_VALUE  ="Radio button is Not checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),RADIO_BUTTON_VALUE);
    }

    @Test(dataProvider = "getDataRadioButtonsDemo")
    public void ValidateTextAfterCheckRadioButtons(String gender,String age,String genderIndex,String ageIndex){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.getGenderRadioButton(Integer.parseInt(genderIndex)).click();
        radioButtonsDemoPage.getAgeGroupRadioButtons(Integer.parseInt(ageIndex)).click();
        radioButtonsDemoPage.getGetValuesButton().click();
        Assert.assertEquals(radioButtonsDemoPage.getGroupTextValue(),"Sex : " + gender + "\nAge group: " + age);

    }


    @DataProvider
    public Object[][] getDataRadioButtonsDemo() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\RadioButtonsDemoDataProvider.xlsx";
        return testData(path,0);

    }

}
