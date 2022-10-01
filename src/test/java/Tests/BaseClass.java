package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties properties;


    public WebDriver setup() throws IOException {

        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") +"\\config\\config.properties");
        properties.load(fileInputStream);

        String browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browserName.equalsIgnoreCase("ie")){
            WebDriverManager.chromedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    @AfterMethod
    public void tearDown(){
       driver.quit();
    }

    public void getScreenShotPath() {

    }


}
