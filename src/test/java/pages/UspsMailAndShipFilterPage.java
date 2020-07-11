package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static support.TestContext.getDriver;

public class UspsMailAndShipFilterPage extends UspsHeader{

    public UspsMailAndShipFilterPage() {

        url = "https://www.usps.com/search/results.htm?keyword=Free%20Boxes&PNO=1&Nrpp=10&navFolder=N-1k4w0hc?&navSteps=1&navDisplayName=Filter%20by%20Category&mainDirName=Mail%20amp;%20Ship(7)";
    }

    @FindBy(xpath = "//span[@id='searchResultsHeading']")
    private WebElement heading;

    @FindBy(xpath = "//ul[@id='records']/li")
    private  List<WebElement>  resultsList;

    private WebElement selectResultWebElement(String searchResult){
        return getDriver().findElement(By.xpath("//span[contains(text(),'" + searchResult + "')]"));
    }

    public UspsPriorityMail getSelectInResults(String searchResultText){

        waitingToBeVisible(selectResultWebElement(searchResultText));
        click(selectResultWebElement(searchResultText));
        return new UspsPriorityMail();
    }

    public  List<WebElement> getAllResultsList(){
        return resultsList;
    }

    public String getHeadingText(){
        return heading.getText();
    }

}
