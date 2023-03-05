package PageObject.Intermediate;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.GenericsMethods.selectDropDown;
import static Utility.WaitForElement.*;

public class JQuerySelectDropdownPage {

    protected WebDriver driver;

    public JQuerySelectDropdownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Drop Down with Search box*************

    @FindBy(xpath = "//span[@aria-labelledby='select2-country-container']")
    @CacheLookup
    private WebElement selectCountryDropDown;

    @FindBy(className = "select2-results__option")
    @CacheLookup
    private List<WebElement> listOfCountry;

    @FindBy(xpath = "//span[@class='select2-selection select2-selection--single']")
    @CacheLookup
    private WebElement selectedCountry;

    //*************Select Multiple Values*************

    @FindBy(xpath = "//input[@placeholder='Select state(s)']")
    @CacheLookup
    private WebElement selectListOfStates;


    @FindBy(xpath= "//li[@class='select2-selection__choice']")
    @CacheLookup
    private List<WebElement> selectedStates;

    //*************DropDown with Disabled values*************

    @FindBy(xpath= "//select[@class='js-example-disabled-results select2-hidden-accessible']")
    @CacheLookup
    private WebElement dropDownWithDisablesValues;

    @FindBy(xpath= "//select[@class='js-example-disabled-results select2-hidden-accessible']/option")
    @CacheLookup
    private List<WebElement> dropDownWithDisablesValuesList;

    //*************DropDown with Category related options*************

    @FindBy(id = "files")
    @CacheLookup
    private WebElement dropDownWithCategory;

    @FindBy(xpath= "//select[@id='files']/optgroup/option")
    @CacheLookup
    private List<WebElement> dropDownWithDCategoryList;

    //*************Drop Down with Search box*************

    public JQuerySelectDropdownPage clickSelectCountryDropDown() {
        waitUntilElementIsClickable(selectCountryDropDown,driver);
        selectCountryDropDown.click();
        return this;
    }

    public List<WebElement> getListOfCountry() {
        waitUntilAllElementsAreVisible(listOfCountry,driver);
        return listOfCountry;
    }

    public WebElement getSelectedCountry(){
        waitUntilElementIsVisible(selectedCountry,driver);
        return selectedCountry;
    }
    //*************Select Multiple Values*************

    public JQuerySelectDropdownPage selectElement(String text){
        waitUntilElementIsClickable(selectListOfStates,driver);
        selectListOfStates.click();
        selectListOfStates.sendKeys(text);
        selectListOfStates.sendKeys(Keys.ENTER);
        return this;
    }

    public List<WebElement> getSelectedStates() {
        waitUntilAllElementsAreVisible(selectedStates,driver);
        return selectedStates;
    }

    //*************DropDown with Disabled values*************
    public JQuerySelectDropdownPage getValueFromDropdownWithDisabledValues(String text){
        waitUntilElementIsVisible(dropDownWithDisablesValues,driver);
        selectDropDown(dropDownWithDisablesValues,text);
        return this;
    }

    public List<WebElement> getListOFDropdownWithDisabledValues(){
        waitUntilAllElementsAreVisible(dropDownWithDisablesValuesList,driver);
        return dropDownWithDisablesValuesList;
    }

    //*************DropDown with Category related options*************

    public JQuerySelectDropdownPage getValueFromDropdownWithCategory(String text){
        waitUntilElementIsVisible(dropDownWithCategory,driver);
        selectDropDown(dropDownWithCategory,text);
        return this;
    }

    public List<WebElement> getListOFDropdownWithCategory(){
        waitUntilAllElementsAreVisible(dropDownWithDCategoryList,driver);
        return dropDownWithDCategoryList;
    }
}
