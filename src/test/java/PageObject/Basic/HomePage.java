package PageObject.Basic;

import Utility.DifficultyOfExercises;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.WaitForElement.waitUntilElementIsClickable;

public class HomePage{

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='round-tabs two']")
    @CacheLookup
    private WebElement basicBtn;

    @FindBy(xpath = "//span[@class='round-tabs three']")
    @CacheLookup
    private WebElement intermediateBtn;

    @FindBy(xpath = "//span[@class='round-tabs four']")
    @CacheLookup
    private WebElement advancedBtn;

    @FindBy(xpath = "//div[@id='basic']//a[@class='list-group-item']")
    @CacheLookup
    private List<WebElement> listOfBasicExercises;

    @FindBy(xpath = "//div[@id='intermediate']//a[@class='list-group-item']")
    @CacheLookup
    private List<WebElement> listOfIntermediateExercises;

    @FindBy(xpath = "//div[@id='advanced']//a[@class='list-group-item']")
    @CacheLookup
    private List<WebElement> listOfAdvancedExercises;

    public HomePage goToExercisesWebsite(DifficultyOfExercises difficultyOfExercises) {

        switch (difficultyOfExercises) {
            case BASIC -> {
                waitUntilElementIsClickable(basicBtn,driver);
                basicBtn.click();
            }
            case INTERMEDIATE -> {
                waitUntilElementIsClickable(intermediateBtn,driver);
                intermediateBtn.click();
            }
            case ADVANCED -> {
                waitUntilElementIsClickable(advancedBtn,driver);
                advancedBtn.click();
            }
        }
        return this;
    }

    public HomePage chooseBasicExample(int indexOfExample){
        waitUntilElementIsClickable(listOfBasicExercises.get(indexOfExample),driver);
        listOfBasicExercises.get(indexOfExample).click();
        return this;
    }

    public HomePage chooseIntermediateExample(int indexOfExample){
        waitUntilElementIsClickable(listOfIntermediateExercises.get(indexOfExample),driver);
        listOfIntermediateExercises.get(indexOfExample).click();
        return this;
    }

    public HomePage chooseAdvancedExample(int indexOfExample){
        waitUntilElementIsClickable(listOfAdvancedExercises.get(indexOfExample),driver);
        listOfAdvancedExercises.get(indexOfExample).click();
        return this;
    }

}






