package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Loggable;
import support.RestWrapper;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs implements Loggable {

    @Given("I login via REST as {string}")
    public void iLoginViaRESTAs(String role) {

        Map<String, String> user = getData(role);
        new RestWrapper().login(user);
    }

    @When("I create via REST {string} position")
    public void iCreateViaRESTPosition(String positionType) {

        Map<String, String> position = getPosition(positionType);
        new RestWrapper().createPosition(position);

    }

    @Then("I verify via REST new position is in the list")
    public void iVerifyViaRESTNewPositionIsInTheList() {
        List<Map<String, Object>> actualPositions = new RestWrapper().getPositions();
        Map<String, Object> expectedPosition = getTestDataMap("newPosition");

        getLogger().info("Verifying if position in the list");
        boolean isFound = false;
        for(Map<String, Object> actualPosition : actualPositions){
            if(actualPosition.get("id").equals(expectedPosition.get("id"))){
                isFound = true;

                for(String key : expectedPosition.keySet()){   // we take 'expectedPosition' because 'actualPosition' could have more fields
                    Object expected = expectedPosition.get(key);
                    Object actual = actualPosition.get(key);

                    System.out.println("Verifying: " + key);
                    System.out.println("Expected: " + expected);
                    System.out.println("Actual: " + actual);

                    assertThat(actual).isEqualTo(expected);
                }
                break; // once we found for id (keySet) - it will go out of the loop
            }
        }
        assertThat(isFound).isTrue();

    }

    @When("I update via REST {string} position")
    public void iUpdateViaRESTPosition(String positionType) {
        Map<String, String> updatedPosition = getPosition(positionType + "_updated");
        Object id = getTestDataMap("newPosition").get("id");
        new RestWrapper().updatePosition(updatedPosition, id);
    }

    @Then("I verify via REST new position is updated")
    public void iVerifyViaRESTNewPositionIsUpdated() {
        Map<String, Object> expectedPosition = getTestDataMap("newPosition");
        Object id = expectedPosition.get("id");
        Map<String, Object> actualPosition = new RestWrapper().getPositionById(id);

        for (String key : expectedPosition.keySet()){
            assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
        }
    }

    @When("I delete via REST new position")
    public void iDeleteViaRESTNewPosition() {
        Object id = getTestDataMap("newPosition").get("id");
        new RestWrapper().deletePositionById(id);
        getLogger().info("Error in deletion");
    }

    @Then("I verify via REST new position is deleted")
    public void iVerifyViaRESTNewPositionIsDeleted() {
        List<Map<String, Object>> actualPositions = new RestWrapper().getPositions();
        Object deletedId = getTestDataMap("newPosition").get("id");
        for (Map<String, Object> position : actualPositions){
            assertThat(position.get("id")).isNotEqualTo(deletedId);
        }
    }

    @When("I create via REST {string} candidate")
    public void iCreateViaRESTCandidate(String candidateTitle) {
        Map<String, String> candidate = getCandidate(candidateTitle);
        new RestWrapper().createCandidate(candidate);
    }

    @Then("I verify via REST new candidate is in the list")
    public void iVerifyViaRESTNewCandidateIsInTheList() {
        List<Map<String, Object>> actualCandidates = new RestWrapper().getCandidates();
        Map<String, Object> expectedCandidate = getTestDataMap("newCandidate");

        boolean isFound = false;
        for (Map<String, Object> actualCandidate : actualCandidates) {
            if (actualCandidate.get("id").equals(expectedCandidate.get("id"))) {
                isFound = true;
                for(String key : expectedCandidate.keySet()) {
                    if (key.equals("password")) {
                        continue;
                    }
                    Object expected = expectedCandidate.get(key);
                    Object actual = actualCandidate.get(key);
                    System.out.println("Verifying: " + key);
                    System.out.println("Expected: " + expected);
                    System.out.println("Actual: " + actual);
                    assertThat(actual).isEqualTo(expected);
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST {string} candidate")
    public void iUpdateViaRESTCandidate(String candidateTitle) {
        Map<String, String> updatedCandidate = getCandidate(candidateTitle + "_updated");
        Object id = getTestDataMap("newCandidate").get("id");
        new RestWrapper().updateCandidate(updatedCandidate, id);
    }

    @Then("I verify via REST new candidate is updated")
    public void iVerifyViaRESTNewCandidateIsUpdated() {

        Map<String, Object> expectedCandidate = getTestDataMap("newCandidate");
        Object id = expectedCandidate.get("id");
        Map<String, Object> actualCandidate = new RestWrapper().getCandidateById(id);
        for(String key : expectedCandidate.keySet()) {
            if (key.equals("password")) {
                continue;
            }
            assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
        }
    }

    @When("I delete via REST new candidate")
    public void iDeleteViaRESTNewCandidate() {
        Object id = getTestDataMap("newCandidate").get("id");
        new RestWrapper().deleteCandidateById(id);
    }

    @Then("I verify via REST new candidate is deleted")
    public void iVerIfyViaRESTNewCandidateIsDeleted() {
        List<Map<String, Object>> actualCandidates = new RestWrapper().getCandidates();
        Object deletedId = getTestDataMap("newCandidate").get("id");
        for (Map<String, Object> candidate : actualCandidates){
            assertThat(candidate.get("id")).isNotEqualTo(deletedId);
        }
    }
}
