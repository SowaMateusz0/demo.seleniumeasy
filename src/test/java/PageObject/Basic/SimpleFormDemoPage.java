package PageObject.Basic;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        enterMessageBox.sendKeys(text);
        return this;
    }

    public SimpleFormDemoPage clickShowMessageButton(){
        showMessageButton.click();
        return this;
    }

    public String getMessage() {
        return message.getText();
    }

    //*************Two Input Fields*************

    public SimpleFormDemoPage enterFirstNumber(String num1){
        firstSumValue.sendKeys(num1);
        return this;
    }

    public SimpleFormDemoPage enterSecondNumber(String num2){
        secondSumValue.sendKeys(num2);
        return this;
    }

    public SimpleFormDemoPage clickGetTotalButton(){
        getTotal.click();
        return this;
    }

    public String getValue() {
        return showSumValue.getText();
    }






















}
