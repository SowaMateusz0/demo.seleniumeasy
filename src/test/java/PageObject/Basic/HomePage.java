package PageObject.Basic;

import Utility.DifficultyOfExercises;
import Utility.GenericsMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends GenericsMethods {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
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

    public void goToExercisesWebsite(DifficultyOfExercises difficultyOfExercises, int indexOfExample){

        switch (difficultyOfExercises) {
                case BASIC-> {
                    waitForElementToBeVisible(basicBtn);
                    basicBtn.click();
                    listOfBasicExercises.get(indexOfExample).click();
                }
                case INTERMEDIATE -> {
                    waitForElementToBeVisible(intermediateBtn);
                    intermediateBtn.click();
                    listOfIntermediateExercises.get(indexOfExample).click();
                }
                case ADVANCED -> {
                    waitForElementToBeVisible(advancedBtn);
                    advancedBtn.click();
                    listOfAdvancedExercises.get(indexOfExample).click();
                }
            }
        }
    }






