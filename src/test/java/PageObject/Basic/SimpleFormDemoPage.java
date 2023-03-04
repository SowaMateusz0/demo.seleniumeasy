package PageObject.Basic;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.waits.WaitForElement.waitUntilElementIsClickable;
import static Utility.waits.WaitForElement.waitUntilElementIsVisible;

public class SimpleFormDemoPage extends GenericsMethods {

    WebDriver driver;

    public SimpleFormDemoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Single Input Field*************
    @FindBy(id = "user-message")
    @CacheLookup
    private WebElement enterMessageBox;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    @CacheLookup
    private WebElement showMessageButton;

    @FindBy(id = "display")
    @CacheLookup
    private WebElement message;

    //*************Two Input Fields*************
    @FindBy(id = "sum1")
    @CacheLookup
    private WebElement firstSumValue;

    @FindBy(id = "sum2")
    @CacheLookup
    private WebElement secondSumValue;

    @FindBy(xpath = "//button[@class='btn btn-default' and text()='Get Total']")
    private WebElement getTotal;

    @FindBy(id = "displayvalue")
    private WebElement showSumValue;


    //*************Single Input Field*************
    public SimpleFormDemoPage setEnterMessageBox(String text){
        waitUntilElementIsVisible(enterMessageBox,driver);
        enterMessageBox.sendKeys(text);
        return this;
    }

    public SimpleFormDemoPage clickShowMessageButton(){
        waitUntilElementIsClickable(showMessageButton,driver);
        showMessageButton.click();
        return this;
    }

    public String getMessage() {
        waitUntilElementIsVisible(message,driver);
        return message.getText();
    }

    //*************Two Input Fields*************

    public SimpleFormDemoPage enterFirstNumber(String number_one){
        waitUntilElementIsVisible(firstSumValue,driver);
        firstSumValue.sendKeys(number_one);
        return this;
    }

    public SimpleFormDemoPage enterSecondNumber(String number_two){
        waitUntilElementIsVisible(secondSumValue,driver);
        secondSumValue.sendKeys(number_two);
        return this;
    }

    public SimpleFormDemoPage clickGetTotalButton(){
        waitUntilElementIsClickable(getTotal,driver);
        getTotal.click();
        return this;
    }

    public String getValue() {
        waitUntilElementIsVisible(secondSumValue,driver);
        return showSumValue.getText();
    }






















}
