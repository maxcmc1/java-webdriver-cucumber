package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class CandidateCareersPage extends CareersHeader{


    private WebElement candidatesPositionCards(String title){
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']"));
    }

    private WebElement positionCardCheck(String title){
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/../../..//button//i"));
    }


    public RecruitCareersPage clickPosition(String title){
        WebElement positionTitle = candidatesPositionCards(title);
        waitingToBeVisible(positionTitle);
        click(positionTitle);
        return new RecruitCareersPage();
    }

    public CandidateCareersPage moveToPosition(String title){
        WebElement positionTitleCard = candidatesPositionCards(title);
        getActions().moveToElement(positionTitleCard).perform();
        return new CandidateCareersPage();
    }

    public boolean isPositionCheckDisplayed(String title){
        try {
            waitingToBeVisible(positionCardCheck(title));
            return positionCardCheck(title).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

}
