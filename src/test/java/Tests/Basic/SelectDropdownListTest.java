package Tests.Basic;

import PageObject.HomePage;
import PageObject.SelectDropdownListPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.v6.A;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public Object[][] getDataSelectDropdownSingleList(){

        Object[][] data = new Object[6][2];

        data[0][0] = "Sunday";
        data[0][1] = "Day selected :- Sunday";

        data[1][0] = "Monday";
        data[1][1] = "Day selected :- Monday";

        data[2][0] = "Tuesday";
        data[2][1] = "Day selected :- Tuesday";

        data[3][0] = "Thursday";
        data[3][1] = "Day selected :- Thursday";

        data[4][0] = "Friday";
        data[4][1] = "Day selected :- Friday";

        data[5][0] = "Saturday";
        data[5][1] = "Day selected :- Saturday";

        return data;
    }



}
