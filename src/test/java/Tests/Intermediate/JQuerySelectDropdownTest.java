package Tests.Intermediate;

import PageObject.Basic.HomePage;
import PageObject.Intermediate.JQuerySelectDropdownPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JQuerySelectDropdownTest extends BaseClass {

    WebDriver driver;

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void ValidateDropDownWithSearchBox(){

        final String country = "Japan";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,2);
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage(driver);

        jQuerySelectDropdownPage.clickSelectCountryDropDown();
        List<WebElement> list = jQuerySelectDropdownPage.getListOfCountry().stream().filter(s -> s.getText().contains(country)).toList();
        list.forEach(WebElement::click);

        Assert.assertEquals(jQuerySelectDropdownPage.getSelectedCountry().getText(),country);
    }

    @Test
    public void ValidateSelectMultipleValues() throws InterruptedException {

        final String state1 = "Alabama";
        final String state2 = "Alaska";

        ArrayList<String> expectedStates = new ArrayList<>();
        expectedStates.add("×Alabama");
        expectedStates.add("×Alaska");

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,2);
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage(driver);

        jQuerySelectDropdownPage.selectElement(state1);
        jQuerySelectDropdownPage.selectElement(state2);

        ArrayList<String> actualStates = new ArrayList<>();

        for (WebElement e : jQuerySelectDropdownPage.getSelectedStates()) {
            actualStates.add(e.getText());
        }
        Assert.assertEquals(actualStates,expectedStates);
    }

    @Test
    public void ValidateDropdownWithDisabledValues(){

        final String expected = "Puerto Rico";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,2);
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage(driver);

        jQuerySelectDropdownPage.getValueFromDropdownWithDisabledValues(expected);

        Assert.assertEquals(jQuerySelectDropdownPage.getListOFDropdownWithDisabledValues().get(3).getText(),expected);
    }

    @Test
    public void ValidateDropdownWithCategory(){

        final String expected = "Java";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.INTERMEDIATE,2);
        JQuerySelectDropdownPage jQuerySelectDropdownPage = new JQuerySelectDropdownPage(driver);

        jQuerySelectDropdownPage.getValueFromDropdownWithCategory(expected);

        Assert.assertEquals(jQuerySelectDropdownPage.getListOFDropdownWithCategory().get(4).getText(),expected);
    }

}
