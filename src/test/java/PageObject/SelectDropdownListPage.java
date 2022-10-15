package PageObject;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectDropdownListPage extends GenericsMethods {

    WebDriver driver;

    public SelectDropdownListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Select List Demo*************

    @FindBy(xpath = "//select[@id='select-demo']/option[position()>1]")
    @CacheLookup
    private List<WebElement> selectListDemo;

    @FindBy(id = "select-demo")
    @CacheLookup
    private WebElement singleList;

    @FindBy(className = "selected-value")
    @CacheLookup
    private WebElement outputTextSingleDropDownList;

    //*************Multi Select List Demo*************

    @FindBy(xpath = "//select[@id='multi-select']/option")
    private List<WebElement> allElementsFromMultiSelectList;

    @FindBy(xpath = "//select[@id='multi-select']")
    private WebElement ListOfMultiSelectDropDown;

    @FindBy(id = "printMe")
    @CacheLookup
    private WebElement firstSelectedButton;

    @FindBy(id = "printAll")
    @CacheLookup
    private WebElement getAllSelectedButton;

    @FindBy(className = "getall-selected")
    @CacheLookup
    private WebElement getOutputTextMultiSelectDropDownList;

    public WebElement listOfAllDays(){
        return singleList;
    }

    public String getOutputTextFromSingleSelectDropDownList(){
        return outputTextSingleDropDownList.getText();
    }

    public void selectElementFromDropDownMenu(WebElement element,String visibleText){
        selectDropDown(element,visibleText);
    }

    public WebElement getGetAllSelectedButton() {
        return getAllSelectedButton;
    }

    public String getGetTextFromMultiSelect() {
        return getOutputTextMultiSelectDropDownList.getText();
    }

    public WebElement getIndexOfElementFromMultiSelectList(int index){
        return allElementsFromMultiSelectList.get(index);
    }
}