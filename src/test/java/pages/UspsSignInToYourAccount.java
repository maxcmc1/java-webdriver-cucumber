package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsSignInToYourAccount extends Page{

    public UspsSignInToYourAccount() {

        url = "https://reg.usps.com/entreg/LoginAction_input?app=GSS&appURL=https://cns.usps.com/labelInformation.shtml";
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    public WebElement getUsername(){
        return username;
    }

    public String getWindowHandle(){
        return getDriver().getWindowHandle();
    }

}
