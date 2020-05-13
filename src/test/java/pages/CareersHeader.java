package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.getWait;

public class CareersHeader extends Page{



    @FindBy(xpath = "//a[@href='/login']/button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='logout-box']/a")
    private WebElement loggedUserName;

    @FindBy(xpath = "//a[@href='/recruit']/button")
    private WebElement recruitButton;

    @FindBy(xpath = "//span[text()='Position']")
    private WebElement positionHeader;

    @FindBy(xpath = "//a[@href='/new_candidate']/button")
    private WebElement applyButton;

    @FindBy(xpath = "//div[@id='shuffle']/nav[contains(@class,'top')]")
    private WebElement header;

    @FindBy(xpath = "//button[text()='Careers']")
    private WebElement careersButton;

    @FindBy(xpath = "//a[@href='/my_jobs']/button")
    private WebElement myJobsButton;

    @FindBy(xpath = "//span[text()='Careers']")
    private WebElement careersHeader;


    public MyJobsCareersPage clickMyJobsButton(){
        click(myJobsButton);
        return new MyJobsCareersPage();
    }

    public CandidateCareersPage clickCareersButton(){
        click(careersButton);
        return new CandidateCareersPage();
    }


    public RecruitCareersPage clickRecruit(){
        click(recruitButton);
        return new RecruitCareersPage();
    }

    public String getloggedUserName(){
        return loggedUserName.getText();
    }

    public LoginCareersPage clickLogin(){
        loginButton.click();
        return new LoginCareersPage();
    }

    public void positionHeaderToBeVisible(){
        getWait().until(ExpectedConditions.visibilityOf(positionHeader));
    }

    public CareersHeader careersHeaderToBeVisible(){
        getWait().until(ExpectedConditions.visibilityOf(careersHeader));
       return new CareersHeader();
    }

    public CareersCandidate clickApply(){
        click(applyButton);
        return new CareersCandidate();
    }

    public CareersCandidate clickUserName(){
        click(loggedUserName);
        return new CareersCandidate();
    }

    public String getHeaderText(){
        return header.getText();
    }

}
