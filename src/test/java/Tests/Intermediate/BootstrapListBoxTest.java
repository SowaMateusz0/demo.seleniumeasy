package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.BootstrapListBoxPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class BootstrapListBoxTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test(dataProvider = "getData")
    public void ValidateMoveAllElementsFromBox1ToBox2(String element1,String element2,String element3,String element4,String element5,String element6,String element7,String element8,String element9,String element10){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE).chooseBasicExample(3);
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);

        ArrayList<String> expectedElementsInList = new ArrayList<>();
        expectedElementsInList.add(element1);
        expectedElementsInList.add(element2);
        expectedElementsInList.add(element3);
        expectedElementsInList.add(element4);
        expectedElementsInList.add(element5);
        expectedElementsInList.add(element6);
        expectedElementsInList.add(element7);
        expectedElementsInList.add(element8);
        expectedElementsInList.add(element9);
        expectedElementsInList.add(element10);

        bootstrapListBoxPage.clickSelectAllElementsFromLeftTableButton().clickMoveElementsToRightBox();

        ArrayList<String> actualElementsInRightBox = new ArrayList<>();

        for (WebElement element: bootstrapListBoxPage.getSecondBoxWithElements()) {
            actualElementsInRightBox.add(element.getText());
        }

        Assert.assertEquals(actualElementsInRightBox,expectedElementsInList);

    }

    @Test
    public void validateSearchField(){

        final String inputValue = "Morbi";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE).chooseBasicExample(3);
        BootstrapListBoxPage bootstrapListBoxPage = new BootstrapListBoxPage(driver);

        ArrayList<String> expectedListOfSearchedValues = new ArrayList<>();
        expectedListOfSearchedValues.add("Morbi leo risus");

        bootstrapListBoxPage.enterValueIntoSearchField(inputValue);

        ArrayList<String> actualListOfSearchedValues = new ArrayList<>();

        for (WebElement element: bootstrapListBoxPage.getListOfSearchedElements()) {
            actualListOfSearchedValues.add(element.getText());
        }

        Assert.assertEquals(actualListOfSearchedValues, expectedListOfSearchedValues);




    }

    @DataProvider
    public Object[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Intermediate\\BootstrapListBoxDataProvider.xlsx";
        return testData(path,0);
    }


}
