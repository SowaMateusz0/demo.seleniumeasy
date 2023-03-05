package PageObject.Intermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.GenericsMethods.selectDropDown;
import static Utility.WaitForElement.*;

public class JQueryListBoxPage{

    protected WebDriver driver;

    public JQueryListBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class='pAdd btn btn-primary btn-sm']")
    @CacheLookup
    private WebElement addButton;

    @FindBy(xpath = "//button[@class='pAddAll btn btn-primary btn-sm']")
    @CacheLookup
    private WebElement addAllButton;

    @FindBy(xpath = "//button[@class='pRemove btn btn-primary btn-sm']")
    @CacheLookup
    private WebElement removeButton;

    @FindBy(xpath = "//button[@class='pRemoveAll btn btn-primary btn-sm']")
    @CacheLookup
    private WebElement removeAllButton;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickListResult']/option")
    @CacheLookup
    private List<WebElement> elementsInResultList;

    @FindBy(xpath = "//select[@class='form-control pickListSelect pickData']")
    @CacheLookup
    private WebElement pickListData;

    public JQueryListBoxPage clickAddAllButton(){
        addAllButton.click();
        return this;
    }

    public List<WebElement> getElementsOnRightList(){
        waitUntilAllElementsAreVisible(elementsInResultList,driver);
        return elementsInResultList;
    }

    public JQueryListBoxPage getElementFormPickListData(String text){
        waitUntilElementIsVisible(pickListData,driver);
        selectDropDown(pickListData,text);
        return this;
    }

    public JQueryListBoxPage clickAddButton(){
        waitUntilElementIsClickable(addButton,driver);
        addButton.click();
        return this;
    }

    public JQueryListBoxPage clickRemoveAllButton(){
        waitUntilElementIsClickable(removeAllButton,driver);
        removeAllButton.click();
        return this;
    }

    public JQueryListBoxPage clickRemoveButton(){
        waitUntilElementIsClickable(removeButton,driver);
        removeButton.click();
        return this;
    }
}
