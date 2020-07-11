package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UspsZipCodeByAddress extends UspsHeader {

    public UspsZipCodeByAddress() {
        url = "https://tools.usps.com/zip-code-lookup.htm?byaddress";
    }

    @FindBy(xpath = "//input[@id='tAddress']")
    private WebElement streetAddressInput;

    @FindBy(xpath = "//input[@id='tCity']")
    private WebElement cityInput;

    @FindBy(xpath = "//select[@id='tState']")
    private WebElement stateInput;

    @FindBy(xpath = "//a[@id='zip-by-address']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@id='zipByAddressDiv']")
    private WebElement resultForm;

    @FindBy(xpath = "//div[@class='zipcode-result-address']")
    private List<WebElement> subResultForm;


    public UspsZipCodeByAddress fillAddress(String streetAddressData, String cityData, String stateData) {
        streetAddressInput.sendKeys(streetAddressData);
        cityInput.sendKeys(cityData);
        new Select(stateInput).selectByValue(stateData);
        click(findButton);
        return new UspsZipCodeByAddress();
    }

    public String result() {
        waitingUsingLambda(resultForm);
        return resultForm.getText();
    }


    public List<WebElement> subResult() {
        waitingUsingLambda(resultForm);
        return subResultForm;
    }

}
