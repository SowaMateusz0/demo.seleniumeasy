package PageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class handlewindows {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");

        WebElement e = driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));
        e.click();

        Set<String> windowsIDs = driver.getWindowHandles();
        Iterator<String> iterator = windowsIDs.iterator();
        String ID = iterator.next();
        String ID1 = iterator.next();
        driver.switchTo().window(ID1);
        System.out.println(driver.getCurrentUrl());

    }
}
