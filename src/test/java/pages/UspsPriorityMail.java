package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class UspsPriorityMail extends UspsHeader{

    public UspsPriorityMail() {

        url = "https://www.usps.com/ship/priority-mail.htm";
    }

    private WebElement shipNowButtonLocator(String button){
        return getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')][@target='_blank']"));
    }

    @FindBy(xpath = "//div[contains(text(),'Feedback')]")
    private WebElement feedBackButton;

    public UspsSignInToYourAccount clickShipNowButton(String buttonText) {

        waitingToBeVisible(feedBackButton);
        waitingToBeVisible(shipNowButtonLocator(buttonText));
        click(shipNowButtonLocator(buttonText));
        return new UspsSignInToYourAccount();

    }

}
