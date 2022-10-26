package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.JQueryListBoxPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class JQueryListBoxTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test(dataProvider = "getData")
    public void ValidateAddAllButton(String element1,String element2,String element3,String element4,String element5,String element6
            ,String element7,String element8,String element9,String element10,String element11,String element12,String element13,String element14,String element15){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,4 );
        JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(driver);

        ArrayList<String> expectedElementsOnRightList = new ArrayList<>();
        expectedElementsOnRightList.add(element1);
        expectedElementsOnRightList.add(element2);
        expectedElementsOnRightList.add(element3);
        expectedElementsOnRightList.add(element4);
        expectedElementsOnRightList.add(element5);
        expectedElementsOnRightList.add(element6);
        expectedElementsOnRightList.add(element7);
        expectedElementsOnRightList.add(element8);
        expectedElementsOnRightList.add(element9);
        expectedElementsOnRightList.add(element10);
        expectedElementsOnRightList.add(element11);
        expectedElementsOnRightList.add(element12);
        expectedElementsOnRightList.add(element13);
        expectedElementsOnRightList.add(element14);
        expectedElementsOnRightList.add(element15);

        jQueryListBoxPage.clickAddAllButton();

        ArrayList<String> actualElementsOnRightList = new ArrayList<>();

        for (WebElement element: jQueryListBoxPage.getElementsOnRightList()) {
            actualElementsOnRightList.add(element.getText());
        }

        Assert.assertEquals(actualElementsOnRightList,expectedElementsOnRightList);
    }

    @Test
    public void ValidateAddButton(){

        final String pickedElement = "Isis";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,4 );
        JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(driver);

        jQueryListBoxPage.getElementFormPickListData(pickedElement);
        jQueryListBoxPage.clickAddButton();

        ArrayList<String> expectedListOfElements = new ArrayList<>();
        expectedListOfElements.add(pickedElement);

        ArrayList<String> actualListOfElements = new ArrayList<>();
        for (WebElement element:jQueryListBoxPage.getElementsOnRightList()
             ) {
            actualListOfElements.add(element.getText());
        }

        Assert.assertEquals(actualListOfElements,expectedListOfElements);
    }

    @Test
    public void ValidateRemoveAllButton(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,4 );
        JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(driver);


        jQueryListBoxPage.clickAddAllButton();
        jQueryListBoxPage.clickRemoveAllButton();

        ArrayList<String> expectedElementsOnRightList = new ArrayList<>();
        ArrayList<String> actualElementsOnRightList = new ArrayList<>();

        for (WebElement element: jQueryListBoxPage.getElementsOnRightList()) {
            actualElementsOnRightList.add(element.getText());
        }

        Assert.assertEquals(actualElementsOnRightList,expectedElementsOnRightList);
    }

    @Test
    public void ValidateRemoveButton(){

        final String pickedElement = "Isis";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,4 );
        JQueryListBoxPage jQueryListBoxPage = new JQueryListBoxPage(driver);

        jQueryListBoxPage.getElementFormPickListData(pickedElement);
        jQueryListBoxPage.clickAddButton();

        ArrayList<String> expectedListOfElements = new ArrayList<>();

        ArrayList<String> actualListOfElements = new ArrayList<>();
        for (WebElement element:jQueryListBoxPage.getElementsOnRightList()
        ) {
            element.click();
            jQueryListBoxPage.clickRemoveButton();
        }

        Assert.assertEquals(actualListOfElements,expectedListOfElements);
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Intermediate\\JQueryListBoxDataProvider.xlsx";
        return testData(path,0);
    }

}
