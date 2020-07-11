package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LookUpZipCodePage extends UspsHeader{

    public LookUpZipCodePage(){
        url = "https://tools.usps.com/go/ZipLookupAction!input.action";
    }

    @FindBy(xpath = "//a[contains(@class,'zip-code-address')]")
    private WebElement zipCodeAddress;


    public UspsZipCodeByAddress clickZipCodeAddress(){
        click(zipCodeAddress);
        return new UspsZipCodeByAddress();
    }

}
