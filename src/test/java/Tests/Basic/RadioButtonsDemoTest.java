package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.HomePage;
import PageObject.RadioButtonsDemoPage;
import Tests.BaseClass;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.formula.functions.Na;
import org.openqa.selenium.WebElement;
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
    public void ValidateTextAfterCheckRadioButtons(String gender,String age,int genderIndex,int ageIndex){


        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,2);
        RadioButtonsDemoPage radioButtonsDemoPage = new RadioButtonsDemoPage(driver);


        radioButtonsDemoPage.getGenderRadioButton(genderIndex).click();
        radioButtonsDemoPage.getAgeGroupRadioButtons(ageIndex).click();
        radioButtonsDemoPage.getGetValuesButton().click();
        Assert.assertEquals(radioButtonsDemoPage.getGroupTextValue(),"Sex : " + gender + "\nAge group: " + age);

    }


    @DataProvider
    public Object[][] getDataRadioButtonsDemo() {

        Object[][] data = new Object[6][4];
        data[0][0] = "Male";
        data[0][1] = "0 - 5";
        data[0][2] = 0; //  gender index on List
        data[0][3] = 0; // age index on List

        data[1][0] = "Male";
        data[1][1] = "5 - 15";
        data[1][2] = 0;
        data[1][3] = 1;

        data[2][0] = "Male";
        data[2][1] = "15 - 50";
        data[2][2] = 0;
        data[2][3] = 2;

        data[3][0] = "Female";
        data[3][1] = "0 - 5";
        data[3][2] = 1;
        data[3][3] = 0;

        data[4][0] = "Female";
        data[4][1] = "5 - 15";
        data[4][2] = 1;
        data[4][3] = 1;

        data[5][0] = "Female";
        data[5][1] = "15 - 50";
        data[5][2] = 1;
        data[5][3] = 2;

        return data;

    }

}
