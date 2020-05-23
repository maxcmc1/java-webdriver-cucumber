package support;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static support.TestContext.*;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart(Scenario scenario) {
        TestContext.setTimestamp();
        TestContext.setScenario(scenario);
        TestContext.initialize();
        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
    }

    @Before(value = "@create_position")
    public void createPosition(){
        new RestWrapper()
                .login(getData("recruiter"))
                .createPosition(getPosition("automation"));
    }

    @Before(value = "@create_candidate_and_position")
    public void createCandidate(){
        new RestWrapper()
                .login(getData("recruiter"))
                .createCandidate(getData("candidate"));
        new RestWrapper()
                .createPosition(getPosition("automation"));
    }


    @After(value = "@delete_position")
    public void deletePosition(){
        new RestWrapper()
                .login(getData("recruiter"))
                .deletePositionById(getTestDataMap("newPosition").get("id"));
    }


    @After(value = "@delete_position_if_failed")
    public void deletePositionIfFailed(Scenario scenario) {
        if(scenario.isFailed()){
            deletePosition();
        }
    }

    @After(value = "@delete_candidate")
    public void deleteCandidate(){
        new RestWrapper()
                .login(getData("recruiter"))
                .deleteCandidateById(getTestDataMap("newCandidate").get("id"));
    }


    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        TestContext.teardown();
    }
}
