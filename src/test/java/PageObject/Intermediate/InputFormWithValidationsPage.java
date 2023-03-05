package PageObject.Intermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.GenericsMethods.selectDropDown;
import static Utility.WaitForElement.*;

public class InputFormWithValidationsPage{

    protected WebDriver driver;

    public InputFormWithValidationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //*************Fields*************

    @FindBy(xpath = "//input[@name='first_name']")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@name='last_name']")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='email']")
    @CacheLookup
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='phone']")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(xpath = "//input[@name='address']")
    @CacheLookup
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='city']")
    @CacheLookup
    private WebElement cityField;

    @FindBy(xpath = "//select[@name='state']")
    @CacheLookup
    private WebElement state;

    @FindBy(xpath = "//input[@name='zip']")
    @CacheLookup
    private WebElement zip;

    @FindBy(xpath = "//input[@name='website']")
    @CacheLookup
    private WebElement website;

    @FindBy(xpath = "//input[@name='hosting']")
    @CacheLookup
    private List<WebElement> radioBox;

    @FindBy(xpath = "//textarea[@name='comment']")
    @CacheLookup
    private WebElement comment;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    @CacheLookup
    private WebElement sendButton;

    //*************Text*************

    @FindBy(xpath = "//label[text()='First Name']")
    @CacheLookup
    private WebElement firstNameText;

    @FindBy(xpath = "//label[text()='Last Name']")
    @CacheLookup
    private WebElement lastNameText;

    @FindBy(xpath = "//label[text()='E-Mail']")
    @CacheLookup
    private WebElement emailText;

    @FindBy(xpath = "//label[text()='Phone #']")
    @CacheLookup
    private WebElement phoneText;

    @FindBy(xpath = "//label[text()='Address']")
    @CacheLookup
    private WebElement addressText;

    @FindBy(xpath = "//label[text()='City']")
    @CacheLookup
    private WebElement cityText;

    @FindBy(xpath = "//label[text()='State']")
    @CacheLookup
    private WebElement stateText;

    @FindBy(xpath = "//label[text()='Zip Code']")
    @CacheLookup
    private WebElement zipCodeText;

    @FindBy(xpath = "//label[text()='Website or domain name']")
    @CacheLookup
    private WebElement websiteText;

    @FindBy(xpath = "//label[text()='Do you have hosting?']")
    @CacheLookup
    private WebElement hosting;


    @FindBy(xpath = "//label[text()='Project Description']")
    @CacheLookup
    private WebElement descriptionText;

    //*************Error Messages*************

    @FindBy(xpath = "//small[@data-bv-result='INVALID']")
    @CacheLookup
    private List<WebElement> errorMessages;




    //*************Fields*************

    public InputFormWithValidationsPage enterFirstName(String text){
        waitForInvisibilityOfElement(firstNameField,driver);
        firstNameField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterLastName(String text){
        waitForInvisibilityOfElement(lastNameField,driver);
        lastNameField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterEmail(String text){
        waitForInvisibilityOfElement(emailField,driver);
        emailField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterPhone(String text){
        waitForInvisibilityOfElement(phoneField,driver);
        phoneField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterAddress(String text){
        waitForInvisibilityOfElement(addressField,driver);
        addressField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterCity(String text){
        waitForInvisibilityOfElement(cityField,driver);
        cityField.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage chooseState(WebElement state, String stateName){
        waitUntilElementIsVisible(state,driver);
        selectDropDown(state, stateName);
        return this;
    }

    public WebElement getState(){
        waitUntilElementIsVisible(state,driver);
        return state;
    }

    public InputFormWithValidationsPage enterZipCode(String text){
        waitUntilElementIsVisible(website,driver);
        zip.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage enterWebsite(String text){
        waitUntilElementIsVisible(website,driver);
        website.sendKeys(text);
        return this;
    }

    public InputFormWithValidationsPage doYouWantHaveHostingRadioBox(int index){
        waitUntilElementIsClickable(radioBox.get(index),driver);
        radioBox.get(index).click();
        return this;
    }

    public InputFormWithValidationsPage enterComment(String text){
        waitUntilElementIsVisible(comment,driver);
        comment.sendKeys(text);
        return this;
    }

    //*************Text*************

    public WebElement getFirstNameText(){
        waitUntilElementIsVisible(firstNameText,driver);
        return firstNameText;
    }

    public WebElement getLastNameText(){
        waitUntilElementIsVisible(lastNameText,driver);
        return lastNameText;
    }

    public WebElement getEmailText(){
        waitUntilElementIsVisible(emailText,driver);
        return emailText;
    }

    public WebElement getPhoneText(){
        waitUntilElementIsVisible(firstNameText,driver);
        return firstNameText;
    }

    public WebElement getAddressText(){
        waitUntilElementIsVisible(addressText,driver);
        return addressText;
    }

    public WebElement getCityTextText(){
        waitUntilElementIsVisible(cityText,driver);
        return cityText;
    }

    public WebElement getStateText(){
        waitUntilElementIsVisible(stateText,driver);
        return stateText;
    }

    public WebElement getZipCodeText(){
        waitUntilElementIsVisible(zipCodeText,driver);
        return zipCodeText;
    }

    public WebElement getWebsiteText(){
        waitUntilElementIsVisible(websiteText,driver);
        return websiteText;
    }

    public WebElement getHostingText(){
        waitUntilElementIsVisible(hosting,driver);
        return hosting;
    }

    public WebElement getDescriptionText(){
        waitUntilElementIsVisible(descriptionText,driver);
        return descriptionText;
    }

    public List<WebElement> getRadioBox(){
        waitUntilAllElementsAreVisible(radioBox,driver);
        return radioBox;
    }

    //*************Error Messages*************

    public List<WebElement> getErrorMessages(){
        waitUntilAllElementsAreVisible(errorMessages,driver);
        return errorMessages;
    }

}
