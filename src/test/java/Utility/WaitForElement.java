package Utility;

import Tests.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitForElement extends BaseClass {

    private static final Logger logger = LogManager.getRootLogger();

    private static WebDriverWait getWebDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public static void waitUntilElementIsVisible(WebElement element,WebDriver driver) {
        logger.info("Wait until element is visible: " + element);
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitUntilElementIsClickable(WebElement element,WebDriver driver) {
        logger.info("Wait until element is clickable: " + element);
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilAllElementsAreVisible(List<WebElement> elements, WebDriver driver) {
        logger.info("Wait until elements are visible: " + elements);
        WebDriverWait webDriverWait = getWebDriverWait(driver);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void waitForInvisibilityOfElement(WebElement element, WebDriver driver){
        logger.info("Wait for invisibility of element: " + element);
        WebDriverWait wait = getWebDriverWait(driver);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
}
