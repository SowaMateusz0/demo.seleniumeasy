package PageObject;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonsDemoPage extends GenericsMethods {

    WebDriver driver;

    public RadioButtonsDemoPage(WebDriver driver) {
        super(driver);
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

    public void clickMaleButton() {
        maleRadioButton.click();
    }

    public void clickFemaleButton() {
        femaleRadioButton.click();
    }
    public void getCheckedValueButton() {
        checkedValueButton.click();
    }

    public String getTextValue() {
        return textValue.getText();
    }

    //*************Group Radio Buttons Demo*************

    public WebElement getGenderRadioButton(int index) {
        return genderRadioButton.get(index);
    }

    public List<WebElement> getGenderRadioButton() {
        return genderRadioButton;
    }

    public WebElement getAgeGroupRadioButtons(int index){
        return ageGroupRadioButton.get(index);
    }

    public List<WebElement> getAgeGroupRadioButtons(){
        return ageGroupRadioButton;
    }

    public WebElement getGetValuesButton() {
        return getValuesButton;
    }

    public String getGroupTextValue() {
        return groupTextValue.getText();
    }

}
