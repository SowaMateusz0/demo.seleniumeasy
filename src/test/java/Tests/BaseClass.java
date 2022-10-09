package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import java.io.*;
import java.time.Duration;
import java.util.Iterator;
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

//    public List<HashMap<String,String>> getJsonDataToMap(String filePath) throws IOException, ParseException {
//
//        JSONParser jsonParser = new JSONParser();
//
//        FileReader reader = new FileReader(System.getProperty("user.dir")+"src/test/java/Utility/SumTwoNumbers.json");
//        Object obj = jsonParser.parse(reader);
//        JSONObject empjsonobj = (JSONObject) obj;
//
//        String fname = (String) empjsonobj.get("numberOne");
//        String lname = (String) empjsonobj.get("numberTwo");
//
//        JSONArray array = (JSONArray) empjsonobj.get("numbers");
//
//        for (int i = 0; i<array.size(); i++) {
//            JSONObject address = (JSONObject) array.get(i);
//
//            String street = (String) address.get("numberOne");
//            String city = (String) address.get("numberTwo");
//            String state = (String) address.get("sum");
//
//            System.out.println(i);
//            System.out.println(street);
//            System.out.println(city);
//            System.out.println(state);
//        }
//
////        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
////        ObjectMapper objectMapper = new ObjectMapper();
////        return objectMapper.readValue(jsonContent, new TypeReference<>() {
////        });
//    }








    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = "./screens/"+testCaseName+".png";
        FileUtils.copyFile(source, new File(destinationPath));
        return destinationPath;
    }


}
