package Tests.Basic;

import PageObject.Basic.HomePage;
import PageObject.Basic.SelectDropdownListPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectDropdownListTest extends BaseClass {

    @Test(dataProvider = "getDataSelectDropdownSingleList")
    public void ValidateOutputTextAfterSelectDay(String day,String expected){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(3);
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);

        selectDropdownListPage.selectElementFromDropDownMenu(selectDropdownListPage.listOfAllDays(),day);
        Assert.assertEquals(selectDropdownListPage.getOutputTextFromSingleSelectDropDownList(),expected);
    }


    @Test
    public void ValidateOutputTextAfterSelectCities(){

        final int FIRST_ELEMENT_INDEX = 0;
        final int SECOND_ELEMENT_INDEX = 4;

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(3);
        SelectDropdownListPage selectDropdownListPage = new SelectDropdownListPage(driver);
        Actions actions = new Actions(driver);

        actions.keyDown(Keys.CONTROL).click(selectDropdownListPage.getIndexOfElementFromMultiSelectList(FIRST_ELEMENT_INDEX)).click(selectDropdownListPage.getIndexOfElementFromMultiSelectList(SECOND_ELEMENT_INDEX)).build().perform();
        selectDropdownListPage.getGetAllSelectedButton().click();
        Assert.assertEquals(selectDropdownListPage.getGetTextFromMultiSelect(),"Options selected are : "+ selectDropdownListPage.getIndexOfElementFromMultiSelectList(FIRST_ELEMENT_INDEX).getText() +","+selectDropdownListPage.getIndexOfElementFromMultiSelectList(SECOND_ELEMENT_INDEX).getText());

    }


    @DataProvider()
    public Object[][] getDataSelectDropdownSingleList() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\SelectDropdownListDataProvider.xlsx";
        return testData(path,0);
    }



}
