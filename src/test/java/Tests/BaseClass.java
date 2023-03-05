package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.*;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties properties;
    private final Logger logger = LogManager.getRootLogger();

    @BeforeMethod
    public WebDriver setup() throws IOException {

        String filePath = "\\config\\config.properties";
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + filePath);

        logger.info("Trying to load properties from file: " + filePath);
        properties.load(fileInputStream);
        logger.info("Properties loaded from file: " + filePath);

        String browserName = properties.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            logger.info("ChromeDriver initialized");
            chromeOptions.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.chromedriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            logger.info("FirefoxDriver initialized");
            firefoxOptions.setAcceptInsecureCerts(true);
            driver = new FirefoxDriver(firefoxOptions);
        }
        else if(browserName.equalsIgnoreCase("ie")){
            WebDriverManager.chromedriver().setup();
            logger.info("EdgeDriver initialized");
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.setAcceptInsecureCerts(true);
            driver = new EdgeDriver(edgeOptions);
        }
        else {
            logger.warn("Browser type not found");
        }


        driver.get(properties.getProperty("url"));
        driver.manage().window().maximize();

        return driver;
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public Object[][] testData(String path,int sheetIndex) throws IOException {

        logger.info("Taking data form excel file");

        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(sheetIndex);

        DataFormatter formatter = new DataFormatter();

        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();

        Object[][] data= new Object[rowCount-1][columnCount];

        for (int i = 0; i < rowCount-1 ; i++) {
            row = sheet.getRow(i+1);
            for (int j = 0; j < columnCount ; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j] = formatter.formatCellValue(cell);
            }
        }
        logger.info("Data taken successfully form excel file");
        return data;
    }


    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        logger.info("Taking screenshot");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = "./screens/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationPath));
        logger.info("Screenshot taken successfully");
        return destinationPath;
    }


}
