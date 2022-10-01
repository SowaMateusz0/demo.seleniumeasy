package Assists;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class GenericsMethods {

    WebDriver driver;

    public GenericsMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public int getRandomNumber(){
        Random random = new Random();
        int boundary = 101;
        return random.nextInt(boundary);
    }
}
