package PageObject.Intermediate;

import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class JQueryListBoxPage extends GenericsMethods {

    WebDriver driver;

    public JQueryListBoxPage(WebDriver driver) {
        super(driver);
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
        return elementsInResultList;
    }

    public JQueryListBoxPage getElementFormPickListData(String text){
        selectDropDown(pickListData,text);
        return this;
    }

    public JQueryListBoxPage clickAddButton(){
        addButton.click();
        return this;
    }

    public JQueryListBoxPage clickRemoveAllButton(){
        removeAllButton.click();
        return this;
    }

    public JQueryListBoxPage clickRemoveButton(){
        removeButton.click();
        return this;
    }
}
