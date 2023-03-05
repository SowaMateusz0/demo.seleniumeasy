package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends BaseClass {

    @Test
    public void checkWebSiteTitle(){

        final String WEB_SITE_TITLE = "Selenium Easy - Best Demo website to practice Selenium Webdriver Online";
        Assert.assertEquals(driver.getTitle(),WEB_SITE_TITLE);

    }

}
