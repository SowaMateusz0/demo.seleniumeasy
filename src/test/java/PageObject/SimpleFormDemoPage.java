package PageObject;

import Assists.GenericsMethods;
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
    public void setEnterMessageBox(String text){
        enterMessageBox.sendKeys(text);
    }

    public void clickShowMessageButton(){
        showMessageButton.click();
    }

    public String getMessage() {
        return message.getText();
    }

    //*************Two Input Fields*************

    public void enterFirstNumber(String num1){
        firstSumValue.sendKeys(num1);
    }

    public void enterSecondNumber(String num2){
        secondSumValue.sendKeys(num2);
    }

    public void clickGetTotalButton(){
        getTotal.click();
    }

    public String getValue() {
        return showSumValue.getText();
    }






















}
