package Tests;

import Utility.DifficultyOfExercises;
import PageObject.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends BaseClass {

    @BeforeMethod
    public void initialize() throws IOException {
        driver = setup();
    }

    @Test
    public void checkWebSiteTitle(){

        final String webSiteTitle = "Selenium Easy - Checkbox demo for automation using selenium";

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC,1);
        Assert.assertEquals(webSiteTitle,driver.getTitle());
    }

}
