package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class PostagePriceCalculator extends Page{


    public PostagePriceCalculator() {

        url = "https://postcalc.usps.com/";
    }

    @FindBy(xpath = "//select[@id='CountryID']")
    private WebElement destinationInput;

    private WebElement shapeWebElement(String shapeValue){
       return getDriver().findElement(By.xpath("//input[@value= '" + shapeValue + "']"));
    }


    public void providingDestinationAndShape(String destinationValue, String shapeValue){
        new Select(destinationInput).selectByVisibleText(destinationValue);
        click(shapeWebElement(shapeValue));
    }

}
