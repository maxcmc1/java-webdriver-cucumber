package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsHelpSearchPage extends UspsHeader{

    public UspsHelpSearchPage() {

        url = "https://faq.usps.com/s/";
    }

    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
    private WebElement searchInput;

    @FindBy(xpath = "//ul[@class='slds-has-dividers--bottom']")
    private WebElement formText;


    public void searchText(String text){
        searchInput.sendKeys(text + Keys.RETURN);
    }

    public String getFormText(){
        return formText.getText();
    }

}
