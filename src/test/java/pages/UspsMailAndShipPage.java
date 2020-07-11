package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UspsMailAndShipPage extends UspsHeader{

    public UspsMailAndShipPage() {

        url = "https://www.usps.com/ship/";
    }

    @FindBy(xpath = "//a[contains(@href,'ZipLookupAction!')]")
    private WebElement lookUpZipCode;

    @FindBy(xpath = "//div[@class='kampyle_button-text']")
    private WebElement feedBackButton;

    @FindBy(xpath = "//a[contains(@href,'calculateretailpostage')]")
    private WebElement calculatePrice;

    @FindBy(xpath = "//p/a[contains(@href,'cns')]")
    private WebElement printLabelButton;


    public UspsSignInToYourAccount clickPrintLabelButton(){
        click(printLabelButton);
        return new UspsSignInToYourAccount();
    }

    public LookUpZipCodePage clickLookUpZipCode(){

        waitingToBeVisible(feedBackButton);
        click(lookUpZipCode);
        return new LookUpZipCodePage();
    }

    public PostagePriceCalculator clickCalculatePrice(){

        waitingToBeVisible(feedBackButton);
        click(calculatePrice);
        return new PostagePriceCalculator();
    }

}
