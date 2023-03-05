package Tests.Basic;

import PageObject.Basic.HomePage;
import PageObject.Basic.WindowPopupModalPage;
import Tests.BaseClass;
import Utility.DifficultyOfExercises;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WindowPopupModalTest extends BaseClass {

    @Test(dataProvider = "getDataSingle")
    public void validateWindowPopupTitle(String buttonText,String actualURL1,String actualURL2) {

        HomePage homePage = new HomePage(driver);
        homePage.goToExercisesWebsite(DifficultyOfExercises.BASIC).chooseBasicExample(5);
        WindowPopupModalPage windowPopupModalPage = new WindowPopupModalPage(driver);

        if(buttonText.equalsIgnoreCase("Follow on Twitter")){

         windowPopupModalPage.clickFollowOnTwitterButton();
         Set<String> windowsIDs = driver.getWindowHandles();
         Iterator<String> iterator = windowsIDs.iterator();
         iterator.next();
         String ID1 = iterator.next();
         driver.switchTo().window(ID1);
         Assert.assertEquals(driver.getCurrentUrl(),actualURL1);

      }
         else if(buttonText.equalsIgnoreCase("Like us On Facebook")){

             windowPopupModalPage.clickLikeUsOnFacebookButton();
             Set<String> windowsIDs = driver.getWindowHandles();
             Iterator<String> iterator = windowsIDs.iterator();
             iterator.next();
             String ID1 = iterator.next();
             driver.switchTo().window(ID1);
             Assert.assertEquals(driver.getCurrentUrl(),actualURL1);

            }
         else if(buttonText.equalsIgnoreCase("Follow Twitter & Facebook")){

            Set<String> websitesURL1 = new HashSet<>();
            websitesURL1.add(actualURL1);
            websitesURL1.add(actualURL2);

            windowPopupModalPage.clickFollowTwitterAndFacebook();

            Set<String> windowsID = driver.getWindowHandles();
            Iterator<String> iterator = windowsID.iterator();
            iterator.next();
            String ID1 = iterator.next();
            String ID2 = iterator.next();


            driver.switchTo().window(ID1);
            final String SECOND_URL_WEBSITE = driver.getCurrentUrl();
            driver.switchTo().window(ID2);
            final String THIRD_URL_WEBSITE = driver.getCurrentUrl();

            Set<String> websitesURL = new HashSet<>();

            websitesURL.add(SECOND_URL_WEBSITE);
            websitesURL.add(THIRD_URL_WEBSITE);

            Assert.assertEquals(websitesURL,websitesURL1);
        }
   }



    @DataProvider
    public Object[][] getDataSingle() throws IOException {

        String path = System.getProperty("user.dir") + "\\excelData\\Basic\\WindowPopupModalDataProvider.xlsx";
        return testData(path, 0);
    }

}
