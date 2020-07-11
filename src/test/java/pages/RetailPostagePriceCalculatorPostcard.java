package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetailPostagePriceCalculatorPostcard extends Page{

    public RetailPostagePriceCalculatorPostcard() {

        url = "https://postcalc.usps.com/";
    }

    @FindBy(xpath = "//input[@id='quantity-0']")
    private WebElement quantityInput;

    @FindBy(xpath = "//input[@type='button']")
    private WebElement calculateButton;

    @FindBy(xpath = "//div[@id='total']")
    private WebElement totalCost;


    public RetailPostagePriceCalculatorPostcard definingQuantity(String quantityValue){
        quantityInput.sendKeys(quantityValue);
        click(calculateButton);
        return new RetailPostagePriceCalculatorPostcard();
    }

    public String getTotalCost(){
        return totalCost.getText();
    }

}
