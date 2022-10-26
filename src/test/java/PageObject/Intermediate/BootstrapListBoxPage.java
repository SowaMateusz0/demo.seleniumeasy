package PageObject.Intermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BootstrapListBoxPage {

    WebDriver driver;

    public BootstrapListBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[@class='btn btn-default selector'])[1]")
    @CacheLookup
    private WebElement selectAllElementsFromLeftTable;

    @FindBy(xpath = "(//a[@class='btn btn-default selector'])[2]")
    @CacheLookup
    private WebElement selectAllElementsFromRightTable;

    @FindBy(xpath = "(//ul[@class='list-group']/li)[1]")
    @CacheLookup
    private List<WebElement> firstBoxWithElements;

    @FindBy(xpath = "//div[@class='well']/ul[@class='list-group']/li")
    @CacheLookup
    private List<WebElement> secondBoxWithElements;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm move-right']")
    @CacheLookup
    private WebElement moveElementToRightBox;

    @FindBy(xpath = "(//input[@name='SearchDualList'])[1]")
    @CacheLookup
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='well text-right']/ul/li[not(@style='display: none;')]")
    @CacheLookup
    private List<WebElement> listOfSearchedElements;


    public void clickSelectAllElementsFromLeftTableButton(){
        selectAllElementsFromLeftTable.click();
    }

    public void clickMoveElementsToRightBox(){
        moveElementToRightBox.click();
    }

    public List<WebElement> getSecondBoxWithElements(){
        return secondBoxWithElements;
    }

    public void enterValueIntoSearchField(String text){
        searchField.sendKeys(text);
    }

    public List<WebElement> getListOfSearchedElements(){
        return listOfSearchedElements;
    }

}
