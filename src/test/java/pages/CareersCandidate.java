package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareersCandidate extends CareersHeader{

    @FindBy(xpath = "//label[@for='candidateFirstName']/..//input")
    private WebElement firstName;

    @FindBy(xpath = "//label[@for='candidateLastName']/..//input")
    private WebElement lastName;

    @FindBy(xpath = "//label[@for='candidateEmail']/..//input")
    private WebElement email;

    @FindBy(xpath = "//label[@for='candidatePassword']/..//input")
    private WebElement password;

    @FindBy(xpath = "//label[@for='candidateConfirmPassword']/..//input")
    private WebElement confirmPassword;

    @FindBy(xpath = "//label[@for='candidateSummary']/..//textarea")
    private WebElement candidateSummary;

    @FindBy(xpath = "//label[@for='candidateCity']/..//input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='candidateState']/..//select")
    private WebElement state;

    @FindBy(id = "candidateSubmit")
    private WebElement submit;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//div[@class='card-header']/button")
    private WebElement edit;

    @FindBy(xpath = "//label[@for='candidateSummary']/..//span")
    private WebElement summaryUpdated;

    @FindBy(xpath = "//label[@for='candidateCity']/..//span")
    private WebElement cityUpdated;


    public CandidateCareersPage createCandidate(Map<String, String> candidate) throws InterruptedException {
        fill(firstName, candidate.get("firstName"));
        fill(lastName, candidate.get("lastName"));
        fill(email, candidate.get("email"));
        fill(password, candidate.get("password"));
        fill(confirmPassword, candidate.get("confirmPassword"));
        fill(candidateSummary, candidate.get("summary"));
        fill(city, candidate.get("city"));
        new Select(state).selectByValue(candidate.get("state"));
        click(submit);

        return new CandidateCareersPage();
    }

    public LandingCareersPage clickDeleteAccountButton(){
        click(deleteAccountButton);
        return new LandingCareersPage();
    }

    public CareersCandidate updateCandidate(Map<String, String> candidateUpdated) {
        click(edit);
        candidateSummary.clear();
        city.clear();
        fill(candidateSummary, candidateUpdated.get("summary"));
        fill(city, candidateUpdated.get("city"));
        click(submit);
        return new CareersCandidate();
    }

    public String getSummaryUpdatedText(){
        return summaryUpdated.getText();
    }

    public String getCityUpdated(){
        return cityUpdated.getText();
    }

}
