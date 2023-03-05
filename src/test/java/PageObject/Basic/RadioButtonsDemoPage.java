package PageObject.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.WaitForElement.waitUntilElementIsClickable;
import static Utility.WaitForElement.waitUntilElementIsVisible;

public class RadioButtonsDemoPage {

    protected WebDriver driver;

    public RadioButtonsDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Radio Button Demo*************

    @FindBy(xpath = "//input[@name='optradio' and @value='Male']")
    @CacheLookup
    WebElement maleRadioButton;

    @FindBy(xpath = "//input[@name='optradio' and @value='Female']")
    @CacheLookup
    WebElement femaleRadioButton;

    @FindBy(id = "buttoncheck")
    @CacheLookup
    private WebElement checkedValueButton;

    @FindBy(className = "radiobutton")
    @CacheLookup
    private WebElement textValue;

    //*************Group Radio Buttons Demo*************

    @FindBy(name = "gender")
    @CacheLookup
    private List<WebElement> genderRadioButton;

    @FindBy(name = "ageGroup")
    @CacheLookup
    private List<WebElement> ageGroupRadioButton;

    @FindBy(xpath = "//button[@onclick='getValues();']")
    @CacheLookup
    private WebElement getValuesButton;

    @FindBy(className = "groupradiobutton")
    @CacheLookup
    private WebElement groupTextValue;

    //*************Radio Button Demo*************

    public RadioButtonsDemoPage clickMaleButton() {
        waitUntilElementIsClickable(maleRadioButton,driver);
        maleRadioButton.click();
        return this;
    }

    public RadioButtonsDemoPage clickFemaleButton() {
        waitUntilElementIsClickable(femaleRadioButton,driver);
        femaleRadioButton.click();
        return this;
    }
    public RadioButtonsDemoPage getCheckedValueButton() {
        waitUntilElementIsClickable(checkedValueButton,driver);
        checkedValueButton.click();
        return this;
    }

    public String getTextValue() {
        waitUntilElementIsVisible(textValue,driver);
        return textValue.getText();
    }

    //*************Group Radio Buttons Demo*************

    public WebElement getGenderRadioButton(int index) {
        waitUntilElementIsVisible(genderRadioButton.get(index),driver);
        return genderRadioButton.get(index);
    }

    public WebElement getAgeGroupRadioButtons(int index){
        waitUntilElementIsVisible(ageGroupRadioButton.get(index),driver);
        return ageGroupRadioButton.get(index);
    }

    public WebElement getGetValuesButton() {
        waitUntilElementIsVisible(getValuesButton,driver);
        return getValuesButton;
    }

    public String getGroupTextValue() {
        waitUntilElementIsVisible(groupTextValue,driver);
        return groupTextValue.getText();
    }

}
