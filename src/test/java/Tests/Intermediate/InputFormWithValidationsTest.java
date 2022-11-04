package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.InputFormWithValidationsPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFormWithValidationsTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test(dataProvider = "getInputSuccessData")
    public void ValidateAllSuccessInputCheckTextColor(String firstName,String lastName,String email,String phone,String address,String city,String state,String zipCode, String website,String comment){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,0);
        InputFormWithValidationsPage inputFormWithValidationsPage = new InputFormWithValidationsPage(driver);

        inputFormWithValidationsPage.enterFirstName(firstName);
        inputFormWithValidationsPage.enterLastName(lastName);
        inputFormWithValidationsPage.enterEmail(email);
        inputFormWithValidationsPage.enterPhone(phone);
        inputFormWithValidationsPage.enterAddress(address);
        inputFormWithValidationsPage.enterCity(city);
        inputFormWithValidationsPage.chooseState(inputFormWithValidationsPage.getState(),state);
        inputFormWithValidationsPage.enterZipCode(zipCode);
        inputFormWithValidationsPage.enterWebsite(website);
        inputFormWithValidationsPage.doYouWantHaveHostingRadioBox(0);
        inputFormWithValidationsPage.enterComment(comment);


        List<String> textColor = new ArrayList<>();
        textColor.add(inputFormWithValidationsPage.getFirstNameText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getLastNameText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getEmailText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getPhoneText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getAddressText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getCityTextText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getStateText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getZipCodeText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getWebsiteText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getHostingText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getDescriptionText().getCssValue("color"));

        List<String> textColorAsHex = new ArrayList<>();

        for (String rgbaColor : textColor) {

            String colorAsHex = Color.fromString(rgbaColor).asHex();
            textColorAsHex.add(colorAsHex);
        }

        List<String> expectedTextColorAsHex = new ArrayList<>();

        String greenSuccessColor = "#3c763d";
        String blackColor = "#333333";

        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(greenSuccessColor);
        expectedTextColorAsHex.add(blackColor);
        expectedTextColorAsHex.add(blackColor);
        expectedTextColorAsHex.add(greenSuccessColor);

        Assert.assertEquals(textColorAsHex,expectedTextColorAsHex);
    }

    @Test(dataProvider = "getInputFailureData")
    public void ValidateAllFailureInputCheckTextColor(String firstName,String lastName,String email,String phone,String address,String city,String state,String zipCode,String comment){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,0);
        InputFormWithValidationsPage inputFormWithValidationsPage = new InputFormWithValidationsPage(driver);

        inputFormWithValidationsPage.enterFirstName(firstName);
        inputFormWithValidationsPage.enterLastName(lastName);
        inputFormWithValidationsPage.enterEmail(email);
        inputFormWithValidationsPage.enterPhone(phone);
        inputFormWithValidationsPage.enterAddress(address);
        inputFormWithValidationsPage.enterCity(city);
        inputFormWithValidationsPage.chooseState(inputFormWithValidationsPage.getState(),"Alaska");
        inputFormWithValidationsPage.chooseState(inputFormWithValidationsPage.getState(),state);
        inputFormWithValidationsPage.enterZipCode(zipCode);
        inputFormWithValidationsPage.enterComment(comment);

        List<String> textColor = new ArrayList<>();
        textColor.add(inputFormWithValidationsPage.getFirstNameText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getLastNameText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getEmailText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getPhoneText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getAddressText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getCityTextText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getStateText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getZipCodeText().getCssValue("color"));
        textColor.add(inputFormWithValidationsPage.getDescriptionText().getCssValue("color"));

        List<String> textColorAsHex = new ArrayList<>();

        for (String rgbaColor : textColor) {

            String colorAsHex = Color.fromString(rgbaColor).asHex();
            textColorAsHex.add(colorAsHex);
        }

        List<String> expectedTextColorAsHex = new ArrayList<>();

        final String failureTextColor = "#a94442";

        for (int i = 0; i < textColorAsHex.size(); i++) {
            expectedTextColorAsHex.add(failureTextColor);
        }

        Assert.assertEquals(textColorAsHex,expectedTextColorAsHex);

    }

    @Test(dataProvider = "getErrorMessageData")
    public void ValidateErrorMessage(String firstNameErrorMessage,String lastNameErrorMessage,String emailErrorMessage,String phoneErrorMessage,String addressErrorMessage,String cityErrorMessage,String stateErrorMessage,String zipCodeErrorMessage,String commentErrorMessage){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,0);
        InputFormWithValidationsPage inputFormWithValidationsPage = new InputFormWithValidationsPage(driver);

        String invalidText = "a";

        inputFormWithValidationsPage.enterFirstName(invalidText);
        inputFormWithValidationsPage.enterLastName(invalidText);
        inputFormWithValidationsPage.enterEmail(invalidText);
        inputFormWithValidationsPage.enterPhone(invalidText);
        inputFormWithValidationsPage.enterAddress(invalidText);
        inputFormWithValidationsPage.enterCity(invalidText);
        inputFormWithValidationsPage.chooseState(inputFormWithValidationsPage.getState(),"Alaska");
        inputFormWithValidationsPage.chooseState(inputFormWithValidationsPage.getState(),"Please select your state");
        inputFormWithValidationsPage.enterZipCode(invalidText);
        inputFormWithValidationsPage.enterComment(invalidText);

        ArrayList<String> expectedErrorMessages = new ArrayList<>();

        expectedErrorMessages.add(firstNameErrorMessage);
        expectedErrorMessages.add(lastNameErrorMessage);
        expectedErrorMessages.add(emailErrorMessage);
        expectedErrorMessages.add(phoneErrorMessage);
        expectedErrorMessages.add(addressErrorMessage);
        expectedErrorMessages.add(cityErrorMessage);
        expectedErrorMessages.add(stateErrorMessage);
        expectedErrorMessages.add(zipCodeErrorMessage);
        expectedErrorMessages.add(commentErrorMessage);

        ArrayList<String> errorMessages = new ArrayList<>();

        for (WebElement errorText: inputFormWithValidationsPage.getErrorMessages()) {
            errorMessages.add(errorText.getText());
        }
        Assert.assertEquals(expectedErrorMessages, errorMessages);
    }

    @Test
    public void ValidateSelectedHosingBoxes(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,0);
        InputFormWithValidationsPage inputFormWithValidationsPage = new InputFormWithValidationsPage(driver);

        for (int i = 0; i < inputFormWithValidationsPage.getRadioBox().size() ; i++) {
            inputFormWithValidationsPage.doYouWantHaveHostingRadioBox(i);
            Assert.assertTrue(inputFormWithValidationsPage.getRadioBox().get(i).isSelected());
        }
    }

    @DataProvider
    public Object[][] getInputSuccessData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\InputFormWithValidationDataProvider.xlsx";
        return testData(path, 0);
    }

    @DataProvider
    public Object[][] getInputFailureData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\InputFormWithValidationDataProvider.xlsx";
        return testData(path, 1);
    }

    @DataProvider
    public Object[][] getErrorMessageData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\InputFormWithValidationDataProvider.xlsx";
        return testData(path, 2);
    }

}
