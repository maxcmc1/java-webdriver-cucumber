package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuoteResult extends Page{


    @FindBy(xpath = "//div[@id='quotePageResult']")
    private WebElement result;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreed;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;


    public String getPassword(){
        return password.getText();
    }

    public String getAgreedPrivacy(){
        return agreed.getText();
    }

    public String getResultForm(){
        return result.getText();
    }

}
