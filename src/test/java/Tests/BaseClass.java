package Tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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


//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }


    public Object[][] testData(String path,int sheetIndex) throws IOException {

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
        return data;
    }



    public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonContent, new TypeReference<>() {
        });
    }




    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = "./screens/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationPath));
        return destinationPath;
    }


}
