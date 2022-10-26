package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.Basic.HomePage;
import PageObject.Basic.RadioButtonsDemoPage;
import Tests.BaseClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class RadioButtonsDemoTest extends BaseClass {

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void ValidateButtonTextAfterChoseFemaleRadioBox(){

        String radioButtonValue  ="Radio button 'Female' is checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.clickFemaleButton();
        radioButtonsDemoPage.getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),radioButtonValue);
    }

    @Test
    public void ValidateButtonTextAfterChoseMaleRadioBox(){

        String radioButtonValue  ="Radio button 'Male' is checked";
        ObjectMapper mapper = new ObjectMapper();

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.clickMaleButton();
        radioButtonsDemoPage.getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),radioButtonValue);
    }

    @Test
    public void ValidateButtonTextAWithoutCheckingAnyRadioButtons(){

        String radioButtonValue  ="Radio button is Not checked";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.getCheckedValueButton();
        Assert.assertEquals(radioButtonsDemoPage.getTextValue(),radioButtonValue);
    }

    @Test(dataProvider = "getDataRadioButtonsDemo")
    public void ValidateTextAfterCheckRadioButtons(String gender,String age,String genderIndex,String ageIndex){


        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);

        radioButtonsDemoPage.getGenderRadioButton(Integer.parseInt(genderIndex)).click();
        radioButtonsDemoPage.getAgeGroupRadioButtons(Integer.parseInt(ageIndex)).click();
        radioButtonsDemoPage.getGetValuesButton().click();
        Assert.assertEquals(radioButtonsDemoPage.getGroupTextValue(),"Sex : " + gender + "\nAge group: " + age);

    }


    @DataProvider
    public Object[][] getDataRadioButtonsDemo() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\RadioButtonsDemo.xlsx";
        return testData(path,0);

    }

}
