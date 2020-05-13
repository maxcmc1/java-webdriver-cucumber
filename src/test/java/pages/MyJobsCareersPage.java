package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static support.TestContext.getDriver;

public class MyJobsCareersPage extends CareersHeader{


    private WebElement positionCardApplied(String title){
        return getDriver().findElement(By.xpath("//a[contains(@href,'/positions')]//..//h4[text()='" + title + "']"));
    }


    public boolean isPositionAppliedDisplayed(String title){
        try {
            waitingToBeVisible(positionCardApplied(title));
            return positionCardApplied(title).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public ApplicationFormCareersPage clickPositionCardApplied(String title){
        click(positionCardApplied(title));
        return new ApplicationFormCareersPage();
    }

}
