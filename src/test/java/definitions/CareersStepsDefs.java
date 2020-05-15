package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class CareersStepsDefs {

    Map<String, String> position = getPosition("automation"); // we passing "position" into getData because yml file name is "position"
    Map<String, String> updatedPosition = getPosition("updatedPosition");
    Map<String, String> candidate = getCandidate("candidate");
    Map<String, String> updatedCandidate = getData("candidate_updated");

    @Given("I open {string} page")
    public void iOpenPage(String page) {

        LandingCareersPage landingCareers = new LandingCareersPage();

        switch (page){
            case "careers":
                landingCareers.open();
                break;
            default:
                throw new RuntimeException("Page not supported: " + page);
        }
    }

    @And("I login as {string}")
    public void iLoginAs(String role) {

        Map<String, String> userFromFile = getData(role);
        new LandingCareersPage().clickLogin().login(userFromFile);

    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String userRole) {

//        Map<String, String> userFromFile = getData(userRole);
//
//        String actualName = new LandingCareersPage().getloggedUserName();
//        String expectedNameRecruiter = userFromFile.get("name");
//        String expectedNameCandidate = userFromFile.get("lastName");
//
//        switch (userRole){
//            case "recruiter":
//                assertThat(actualName).isEqualTo(expectedNameRecruiter);
//                break;
//            case "candidate":
//                assertThat(actualName).contains(expectedNameCandidate);
//                break;
//            default:
//                throw new RuntimeException("No user exists: " + userRole);
//        }

        String actualName = new LandingCareersPage().getloggedUserName();
        assertThat(actualName).isEqualTo(new CareersHeader().getName(userRole));

    }

    @When("I remove {string} position")
    public void iRemovePosition(String positionTitle) {

        new LandingCareersPage()
                .clickRecruit()
                .removePosition(positionTitle);

    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String position) {

//        RecruitCareersPage recruitPage = new RecruitCareersPage();

//        assertThat(new RecruitCareersPage().areaErrorPresent()).isFalse();

        new RecruitCareersPage().refresh();
        assertThat(new RecruitCareersPage().isPositionDisplayed(position)).isFalse();

    }

    @When("I create new position")
    public void iCreateNewPosition() {

        new CareersHeader()
                .clickRecruit()
                .clickNewPosition()
                .create(position);

    }

    @Then("I verify new position is created")
    public void iVerifyNewPositionIsCreated() {


        boolean isCreated = new RecruitCareersPage().isPositionDisplayed(position.get("title"));
        assertThat(isCreated).isTrue();

    }

    @When("I remove new position")
    public void iRemoveNewPosition() {

        RecruitCareersPage recruitCareersPage = new RecruitCareersPage();

        String cardTitle = position.get("title");
        String cardUpdatedTitle = updatedPosition.get("title");
        boolean isDisplayed = recruitCareersPage.isPositionDisplayed(cardTitle);
        if(isDisplayed){
            recruitCareersPage.removePosition(cardTitle);
        } else {
            recruitCareersPage.removePosition(cardUpdatedTitle);
        }
    }

    @And("I verify new position is removed")
    public void iVerifyNewPositionIsRemoved() {

        RecruitCareersPage recruitCareersPage = new RecruitCareersPage();

        String cardTitle = position.get("title");
        String cardUpdatedTitle = updatedPosition.get("title");

        recruitCareersPage.refresh();

        boolean isNotDisplayedCard = recruitCareersPage.isPositionDisplayed(cardTitle);
        if(isNotDisplayedCard){
            assertThat(recruitCareersPage.isPositionDisplayed(cardTitle)).isFalse();
        } else {
            assertThat(recruitCareersPage.isPositionDisplayed(cardUpdatedTitle)).isFalse();
        }
    }

    @When("I update new position")
    public void iUpdateNewPosition() {

//        Map<String, Object> expectedPosition = getTestDataMap("newPosition");
//        System.out.println();

        new RecruitCareersPage()
                .clickPositionTitle(position.get("title"))
                .update(updatedPosition);
               new CareersHeader().clickRecruit();
    }

    @Then("I verify new position is updated")
    public void iVerifyNewPositionIsUpdated() {

        boolean isUpdated = new RecruitCareersPage().isPositionDisplayed(updatedPosition.get("title"));
        assertThat(isUpdated).isTrue();

    }

    @And("I use cascading calls")
    public void iUseCascadingCalls() {

        Map<String, String> userFromFile = getData("recruiter");

        boolean isDisplayed = new LandingCareersPage()
                .clickLogin()
                .login(userFromFile)
                .clickRecruit()
                .clickNewPosition()
                .create(position)
                .removePosition(position.get("title"))
                .isPositionDisplayed(position.get("title"));

        assertThat(isDisplayed).isFalse();

    }

    @And("I submit application to a new position")
    public void iSubmitApplicationToANewPosition() throws InterruptedException{

        new LandingCareersPage()
                .clickApply()
                .createCandidate(candidate);
        System.out.println();

    }

    @Then("I verify new candidate is created")
    public void iVerifyNewCandidateIsCreated() {

//        Map<String, String> candidateFromFile = getData("candidate");

        String actualName = new CareersHeader().getloggedUserName();
        String expectedCandidateFromFile = candidate.get("fullName");

        assertThat(actualName).isEqualTo(expectedCandidateFromFile);

        new CandidateCareersPage()
                .clickUserName();
    }

    @When("I delete candidate profile")
    public void iDeleteCandidateProfile() {

        new CareersCandidate().clickDeleteAccountButton();

    }

    @Then("I verify new candidate is removed")
    public void iVerifyNewCandidateIsRemoved() {

//        Map<String, String> userName = getData("candidate");

        LandingCareersPage landingCareersPage = new LandingCareersPage();

        assertThat(landingCareersPage.getHeaderText()).doesNotContain(candidate.get("fullName"));

    }

    @When("I update new candidate")
    public void iUpdateNewCandidate() {
        new CareersCandidate().updateCandidate(updatedCandidate);

    }

    @Then("I verify new candidate is updated")
    public void iVerifyNewCandidateIsUpdated() {

        CareersCandidate careersCandidate = new CareersCandidate();

        assertThat(careersCandidate.getSummaryUpdatedText()).isEqualTo(updatedCandidate.get("summary"));
        assertThat(careersCandidate.getCityUpdated()).isEqualTo(updatedCandidate.get("city"));

    }

    @When("I apply for a new position")
    public void iApplyForANewPosition(){

        new CandidateCareersPage()
                .clickPosition(position.get("title"));

        new ApplicationFormCareersPage()
                .clickApplyOrWithdrawButton();

    }

    @Then("I see new position marked as applied")
    public void iSeeNewPositionMarkedAsApplied(){

        new CareersHeader()
                .clickCareersButton()
                .moveToPosition(position.get("title"));

        assertThat(new CandidateCareersPage().isPositionCheckDisplayed(position.get("title"))).isFalse();

    }

    @And("I see new position in my jobs")
    public void iSeeNewPositionInMyJobs() {


        new CandidateCareersPage()
                .clickMyJobsButton();

        boolean isPositionDisplayed = new MyJobsCareersPage().isPositionAppliedDisplayed(position.get("title"));

        assertThat(isPositionDisplayed).isTrue();

    }

    @When("I withdraw from new position")
    public void iWithdrawFromNewPosition(){

        new MyJobsCareersPage()
                .clickPositionCardApplied(position.get("title"))
                .clickApplyOrWithdrawButton();

    }

    @Then("I don't see new position in my jobs")
    public void iDonTSeeNewPositionInMyJobs(){

        new CareersHeader()
                .careersHeaderToBeVisible()
                .clickMyJobsButton();

        boolean isNewPositionInMyJobsRemoved = new MyJobsCareersPage().isPositionAppliedDisplayed(position.get("title"));

        assertThat(isNewPositionInMyJobsRemoved).isFalse();

    }
}
