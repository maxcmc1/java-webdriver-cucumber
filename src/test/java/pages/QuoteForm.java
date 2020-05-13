package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class QuoteForm extends Page{

    public QuoteForm(){
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }




    // Below is the representation of the fields of the class

    @FindBy(xpath = "//input[@name='username']")     // replacement for 'getDriver()findBy...'        Also - it's called selectors
    private WebElement username;                     //  - Also, it's considered to be fields of the class


    @FindBy(xpath = "//input[@name='email']")     // replacement for 'getDriver()findBy...'     Also - it's called selectors
    private WebElement email;                     //  - Also, it's considered to be fields of the class

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='agreedToPrivacyPolicy']")
    private WebElement privacyPolicy;

// Your xpath query looks //*[@name="firstName"] (same //*[@name="lastName"] ) , and when you filled out your firstName or lastName and clear fields or not xpath query gives you 2 elements for //*[@name = '...'],
// look screenshot. So, we should use By.id (id = 'firstName') or By.xpath (//input[@name='lastName'])


    // 'Name' field pop-up
    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    @FindBy(id = "middleName")
    private WebElement middleName;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;


    @FindBy(id = "formSubmit")
    private WebElement formSubmitButton;

    private WebElement fieldElementId (String fieldName){
        return getDriver().findElement(By.id(fieldName));
    }

    public String getFieldValue(String fieldName){
        return fieldElementId(fieldName).getAttribute("value");
    }

    private WebElement errorElement(String fieldName){
        return getDriver().findElement(By.id(fieldName + "-error"));
    }


    public String getFormFirstLastName(){
        return name.getAttribute("value");
    }


    public String getErrorText(String fieldName){
        return errorElement(fieldName).getText();
    }

    public boolean isErrorDisplayed(String fieldName){
        return errorElement(fieldName).isDisplayed();
    }


    public void clickSubmitButton(){
        formSubmitButton.click();
    }


    public void clickPrivacyCheckBox(){
        privacyPolicy.click();
    }

    public void fillConfirmPassword(String value){
        confirmPassword.sendKeys(value);
    }

    public void fillPassword(String value){
        password.sendKeys(value);
    }


    public void fillName(String first, String last){
        name.click();
        firstName.sendKeys(first);
        lastName.sendKeys(last);
        saveButton.click();
    }

    public void fillNameWithMiddleName(String first, String middle, String last) {
        name.click();
        firstName.sendKeys(first);
        middleName.sendKeys(middle);
        lastName.sendKeys(last);
        saveButton.click();
    }


    public void fillUsername(String value){    // micro method
        username.sendKeys(value);
    }

    public void fillUserEmail(String value){       // micro method
        email.sendKeys(value);
    }

    public void fillAdminEmail(String value){       // micro method
        email.sendKeys(value);
    }


    private WebElement fieldElementName (String fieldName, String tagName){
        String xpathQuery = "//"+tagName+"[@name='"+fieldName+"']";
        List<WebElement> elements = getDriver().findElements(By.xpath(xpathQuery));
        return elements.size() > 0 ? elements.get(0) : null;
    }

    public void clearFieldEl(String fieldName){
        fieldElementName(fieldName, "input").clear();
    }


    public void clearUserName(){
        username.clear();
    }

    public void clearEmail(){
        email.clear();
    }

    public void clearConfirmPassword(){
        confirmPassword.clear();
    }

    public void clearPassword(){
        password.clear();
    }

    public void clearName(){
        name.clear();
    }

}
