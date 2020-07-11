package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class FindLocations extends UspsHeader{

    public FindLocations() {

        url = "https://tools.usps.com/find-location.htm";
    }


    @FindBy(xpath = "//button[@id='post-offices-select']")
    private WebElement locationTypesDropdown;

    @FindBy(xpath = "//button[@id='service-type-select']")
    private WebElement servicesDropdown;

    @FindBy(xpath = "//button[@id='available-service-select']")
    private WebElement availableServicesDropdown;

    private WebElement locationTypesWebElement(String locationType){
        return getDriver().findElement(By.xpath("//a[string()='" + locationType + "']"));
    }

    private WebElement servicesDropdownWebElement(String service){
        return getDriver().findElement(By.xpath("//a[text()='" + service + "']"));
    }

    private WebElement availableServicesDropdownWebElement(String availableService){
        return getDriver().findElement(By.xpath("//a[string()='" + availableService + "']"));
    }

    @FindBy(xpath = "//input[@id='search-input']")
    private WebElement fullAddressInput;

    @FindBy(xpath = "//input[@id='addressLineOne']")
    private WebElement streetAddress;

    @FindBy(xpath = "//input[@id='cityOrZipCode']")
    private WebElement cityOrZipInput;

    @FindBy(xpath = "//select[@id='servicesStateSelect']")
    private WebElement stateDropdown;


    @FindBy(xpath = "//div[contains(@class,'goto')]/a")
    private WebElement goToResultsButton;

    @FindBy(xpath = "//div[@id='resultBox']/div[1]")
    private WebElement resultBox;

    @FindBy(xpath = "//p[@id='detailTollFree']")
    private WebElement phoneNumberWeb;



    public void filteringServices(String locationTypeData, String serviceValue, String availableServiceValue){

        click(locationTypesDropdown);
        click(locationTypesWebElement(locationTypeData));

        click(servicesDropdown);
        click(servicesDropdownWebElement(serviceValue));

        click(availableServicesDropdown);
        click(availableServicesDropdownWebElement(availableServiceValue));

    }

    public void fillingFullAddress(String streetValue, String cityValue, String stateValue){

        click(fullAddressInput);

        streetAddress.sendKeys(streetValue);
        for (int i = 0; !streetAddress.getAttribute("value").equalsIgnoreCase(streetValue) && i < 5; i++){
            streetAddress.clear();
            streetAddress.sendKeys(streetValue);
        }

        cityOrZipInput.sendKeys(cityValue);

        new Select(stateDropdown).selectByValue(stateValue);

        click(goToResultsButton);
    }

    public String getTextPhoneNumber(){
        click(resultBox);
        return phoneNumberWeb.getText();
    }

}
