package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsSearchResultPage extends UspsHeader{

    public UspsSearchResultPage() {

        url = "https://www.usps.com/search/results.htm?keyword=Free%20Boxes&PNO=1&Nrpp=&navFolder=&navSteps=0&navDisplayName=&mainDirName=";
    }

    @FindBy(xpath = "//div[@class='white-spinner-container']")
    private WebElement webElement;

    private WebElement webElementTwo(String filterTab){
        return getDriver().findElement(By.xpath("//a[contains(@title,'" + filterTab + "')]"));
    }

    public void iSetInFilters(String filterTabAgain){

        waitingToBeInVisible(webElement);
        click(webElementTwo(filterTabAgain));
        waitingToBeInVisible(webElement);
    }

}
