package Tests.Basic;

import Utility.DifficultyOfExercises;
import PageObject.Basic.HomePage;
import PageObject.Basic.SimpleFormDemoPage;
import Tests.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.io.IOException;


public class SimpleFormDemoTest extends BaseClass {

    public WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void singleInputField() {

        final String message = "Hello";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC, 0);
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);

        simpleFormDemoPage.setEnterMessageBox(message);
        simpleFormDemoPage.clickShowMessageButton();

        Assert.assertEquals(simpleFormDemoPage.getMessage(), message);
    }


    @Test(dataProvider = "getDataSimpleFormDemo")
    public void twoInputFields(String number1, String number2, String sum){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC, 0);
        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage(driver);

        simpleFormDemoPage.enterFirstNumber(number1);
        simpleFormDemoPage.enterSecondNumber(number2);
        simpleFormDemoPage.clickGetTotalButton();
        Assert.assertEquals(simpleFormDemoPage.getValue(), sum);
    }

    @DataProvider
    public Object[][] getDataSimpleFormDemo() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\SimpleFormDemoDataProvider.xlsx";
        return testData(path,0);
    }


}
