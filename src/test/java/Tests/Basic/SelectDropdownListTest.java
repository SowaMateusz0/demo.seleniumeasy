package Tests.Basic;

import PageObject.Basic.HomePage;
import PageObject.Basic.SelectDropdownListPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectDropdownListTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test(dataProvider = "getDataSelectDropdownSingleList")
    public void ValidateOutputTextAfterSelectDay(String day,String expected){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,3);
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);

        selectDropdownListPage.selectElementFromDropDownMenu(selectDropdownListPage.listOfAllDays(),day);
        Assert.assertEquals(selectDropdownListPage.getOutputTextFromSingleSelectDropDownList(),expected);
    }


    @Test
    public void ValidateOutputTextAfterSelectCities(){

        final int firstElementIndex = 0;
        final int secondElementIndex = 4;

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,3);
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).click(selectDropdownListPage.getIndexOfElementFromMultiSelectList(firstElementIndex)).click(selectDropdownListPage.getIndexOfElementFromMultiSelectList(secondElementIndex)).build().perform();
        selectDropdownListPage.getGetAllSelectedButton().click();
        Assert.assertEquals(selectDropdownListPage.getGetTextFromMultiSelect(),"Options selected are : "+ selectDropdownListPage.getIndexOfElementFromMultiSelectList(firstElementIndex).getText() +"," +selectDropdownListPage.getIndexOfElementFromMultiSelectList(secondElementIndex).getText());

    }


    @DataProvider()
    public Object[][] getDataSelectDropdownSingleList() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\SelectDropdownListDataProvider.xlsx";
        return testData(path,0);
    }



}
