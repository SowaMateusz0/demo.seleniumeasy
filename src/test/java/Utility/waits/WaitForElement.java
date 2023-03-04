package Utility.waits;

import Tests.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitForElement extends BaseClass {

    private static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void waitUntilElementIsVisible(WebElement element,WebDriver driver) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilElementIsClickable(WebElement element,WebDriver driver) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilAllElementsAreVisible(List<WebElement> elements, WebDriver driver) {
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void waitForInvisibilityOfElement(WebElement element, WebDriver driver){
        WebDriverWait wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
