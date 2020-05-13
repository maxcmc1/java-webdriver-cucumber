package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;

public class RecruitCareersPage extends CareersHeader{

    public RecruitCareersPage(){
        url = "https://skryabin-careers.herokuapp.com/recruit";
    }

    // dynamic elements
    private WebElement positionCard(String title){
        return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/../../.."));
    }

    private WebElement closePositionCard(String title){
       return getDriver().findElement(By.xpath("//h4[text()='" + title + "']/../../..//button"));
    }

    // static elements
    @FindBy(xpath = "//a[@href='/new_position']")
    private WebElement newPosition;

    @FindBy(xpath = "//div[@class='container']")
    private WebElement container;


    public void refresh(){
        new LandingCareersPage().open();
        this.open();
    }

    public CareersPosition clickNewPosition(){
        click(newPosition);
        return new CareersPosition();
    }

    public boolean isPositionDisplayed(String title){
        try {
            waitingToBeVisible(positionCard(title));
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }


    public RecruitCareersPage removePosition(String title){
        WebElement positionTitle = positionCard(title);
        WebElement close = closePositionCard(title);
        getActions().moveToElement(positionTitle).perform();
        click(close);
        waitForPositionDisappear(title);
        return new RecruitCareersPage();
    }

    protected RecruitCareersPage waitForPositionDisappear(String title){
        getWait().until(ExpectedConditions.invisibilityOf(positionCard(title)));
        return new RecruitCareersPage();
    }

    protected RecruitCareersPage waitForPositionAppear(String title){
        getWait().until(ExpectedConditions.visibilityOf(positionCard(title)));
        return new RecruitCareersPage();
    }

    public CareersPosition clickPositionTitle(String title){
        WebElement positionTitle = positionCard(title);
        getActions().moveToElement(positionTitle).perform();
        click(positionTitle);
        return new CareersPosition();
    }

}
