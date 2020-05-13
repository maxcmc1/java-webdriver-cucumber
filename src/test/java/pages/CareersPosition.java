package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class CareersPosition extends CareersHeader{

    @FindBy(xpath = "//label[@for='positionTitle']/..//input")
    private WebElement title;

    @FindBy(xpath = "//label[@for='positionDescription']/..//textarea")
    private WebElement description;

    @FindBy(xpath = "//label[@for='positionAddress']/..//input")
    private WebElement address;

    @FindBy(xpath = "//label[@for='positionCity']/..//input")
    private WebElement city;

    @FindBy(xpath = "//label[@for='positionState']/..//select")
    private WebElement state;

    @FindBy(xpath = "//label[@for='positionZip']/..//input")
    private WebElement zip;

    @FindBy(id = "positionDateOpen")
    private WebElement dateOpen;

    @FindBy(id = "positionSubmit")
    private WebElement submit;

    @FindBy(xpath = "//div[@class='card-header']/button")
    private WebElement edit;



    public RecruitCareersPage create(Map<String, String> position) {
        title.sendKeys(position.get("title"));
        description.sendKeys(position.get("description"));
        address.sendKeys(position.get("address"));
        city.sendKeys(position.get("city"));
        new Select(state).selectByValue(position.get("state"));
        zip.sendKeys(position.get("zip"));
        dateOpen.sendKeys(position.get("dateOpen"));
        click(submit);
        return new RecruitCareersPage().waitForPositionAppear(position.get("title")); // title comes as "key" from "position" yml file

    }

    public CareersPosition update(Map<String, String> position) {
        click(edit);
        title.clear();
        title.sendKeys(position.get("title"));
        dateOpen.sendKeys(position.get("dateOpen"));
        click(submit);
        positionHeaderToBeVisible();
        return new CareersPosition();
    }

}
