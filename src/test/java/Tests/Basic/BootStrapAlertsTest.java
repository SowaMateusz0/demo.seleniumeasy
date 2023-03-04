package Tests.Basic;

import PageObject.Basic.BootStrapAlertsPage;
import PageObject.Basic.HomePage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BootStrapAlertsTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void validateNormalMassageAppear(){

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(6);
        BootStrapAlertsPage bootStrapAlertsPage = new BootStrapAlertsPage(driver);

        bootStrapAlertsPage.openNormalMessages();

        for (WebElement element: bootStrapAlertsPage.getNormalMessagesList()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Test(dataProvider = "getData")
    public void validateStyleOfNormalMassage(String text,String color,String backgroundColor) {

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseIntermediateExample(6);
        BootStrapAlertsPage bootStrapAlertsPage = new BootStrapAlertsPage(driver);

        bootStrapAlertsPage.openNormalMessages();

        for (WebElement normalAlert:bootStrapAlertsPage.getNormalAlertsMessage()) {

            Set<String> styleExpected = new HashSet<>();
            styleExpected.add(color);
            styleExpected.add(backgroundColor);

            if(normalAlert.getText().contains(text)){
                Assert.assertEquals(getColorAndBackgroundColor(normalAlert),styleExpected);
            }
        }
    }

    @Test
    public void validateCloseableAlerts() {

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(6);
        BootStrapAlertsPage bootStrapAlertsPage = new BootStrapAlertsPage(driver);
        GenericsMethods genericsMethods = new GenericsMethods(driver);

        for (WebElement buttonToOpenAutocloseableMessage : bootStrapAlertsPage.getAutocloseableListButtons()) {
            buttonToOpenAutocloseableMessage.click();
            for (WebElement autocloseableMessage : bootStrapAlertsPage.getAutocloseableMessagesList()
            ) {
                genericsMethods.waitForInvisibilityOfElement(driver,autocloseableMessage,10);
                Assert.assertFalse(autocloseableMessage.isDisplayed());
            }
        }
    }


    public Set<String> getColorAndBackgroundColor(WebElement element){

        String actualColor = element.getCssValue("color");
        String actualColorOfElement = Color.fromString(actualColor).asHex();

        String actualBackgroundColor = element.getCssValue("background-color");
        String actualBackgroundColorOfElement = Color.fromString(actualBackgroundColor).asHex();

        Set<String> styleActual = new HashSet<>();
        styleActual.add(actualColorOfElement);
        styleActual.add(actualBackgroundColorOfElement);

        return styleActual;
    }

    @DataProvider
    public Object[][] getData() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\BootStrapAlertsDataProvider.xlsx";
        return testData(path, 0);
    }
}
