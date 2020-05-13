package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MarketStepDefs {


    @Given("I go to {string} page")
    public void iGoToPage(String page) {

        switch (page) {
            case"ups":
                getDriver().get("https://www.ups.com/us/en/global.page");
                break;
            case"calculator":
                getDriver().get("https://www.calculator.net/");
                break;
            case"converter":
                getDriver().get("https://www.unitconverters.net/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "yahoo":
                getDriver().get("https://www.yahoo.com/");
                break;
            default:
                throw new RuntimeException("Not recognized page " + page);
        }


    }

    @And("I print page details in console")
    public void iPrintPageDetailsInConsole() {
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getWindowHandle());
        System.out.println(getDriver().getWindowHandles());
        System.out.println(getDriver().getPageSource());
    }


    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Given("I go {string} page")
    public void iGoPage(String page) {
        if (page.equals("google")) {
            getDriver().get("https://www.google.com/");
        } else {
            System.out.println("Page is not def");
        }
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String resolution) {
        if (resolution.equalsIgnoreCase("phone")) {
            getDriver().manage().window().setSize(new Dimension(400, 768));
        } else if (resolution.equalsIgnoreCase("desktop")) {
            getDriver().manage().window().setSize(new Dimension(1024, 768));
        }
    }

    @Then("^I will wait for (\\d+) sec$")
    public void iWillWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 3000);
    }


    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("maxcmc1");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("maxcmc1@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("maxcmc1");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("maxcmc1");
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("Maks Seli"); //
//        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("7777775555");
//        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).click();
//        getDriver().findElement(By.xpath("//select[@*='selectMonth']/option[3]")).click();
//        getDriver().findElement(By.xpath("//select[@*='selectYear']/option[@*='1989']")).click();
//        getDriver().findElement(By.xpath("//select[@*='selectYear']/option[@*='1989']")).click();
//        getDriver().findElement(By.xpath("//td[@*='selectDay']/a[text()='25']")).click();
//        getDriver().findElement(By.xpath("//option[@*='USA']")).click();
//        getDriver().findElement(By.xpath("//input[@ng-model='formData.gender'][@value='male']")).click();
//        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
//        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("1 main st, Chicago IL, 60092");
//        getDriver().findElement(By.xpath("//option[contains(text(),'BMW')]")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I fill out optional fields")
    public void iFillOutOptionalFields() throws InterruptedException{
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("7777775555");
        getDriver().findElement(By.xpath("//input[@id='dateOfBirth']")).sendKeys("03/25/1989");

        Thread.sleep(5000);

        //getDriver().findElement(By.xpath("//option[@*='USA']"));

        WebElement countrySelect = getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']"));
        new Select(countrySelect).selectByValue("China"); // it's better to use this approach for dropdowns. It's also called anonymous class because we didn't save into variable

        Thread.sleep(5000);

        new Select(countrySelect).selectByValue("Germany");

        getDriver().findElement(By.xpath("//input[@ng-model='formData.gender'][@value='male']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("1 main st, Chicago IL, 60092");
        getDriver().findElement(By.xpath("//option[contains(text(),'BMW')]")).click();


    }


    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }


    @And("I verify email field behavior")
    public void iVerifyEmailFieldBehavior() {
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("maxcmc1gmail.com");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("maxcmc1@gmail.com");

    }

    @Then("I verify that form is submitted")
    public void pageIsSubmitted() {

        assertThat(getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).getText()).isEqualTo("Submitted Application");
        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
    }


    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
//        assertThat(getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).isDisplayed()).isTrue();
//        assertThat(getDriver().findElement(By.xpath("//b[@name='password']")).getText()).isEqualTo("[entered]");
//        assertThat(getDriver().findElement(By.xpath("//b[@name='email']")).getText()).contains("maxcmc1");

        String result = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        assertThat(result).containsIgnoringCase("MaXcmc1");
        assertThat(result).contains("[ente");
        assertThat(result).doesNotContain("dsfasf");

        String privacyPolicy = getDriver().findElement(By.xpath("//b[@name='allowedToContact']")).getText();
        assertThat(privacyPolicy).isEqualTo("true");

    }

    @Then("I verify optional fields")
    public void iVerifyOptionalFields() {
        String resultOptional = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        assertThat(resultOptional).contains("7777775555");
        assertThat(resultOptional).contains("03/25/1989");
        assertThat(resultOptional).containsIgnoringCase("Germa");
        assertThat(resultOptional).contains("BMW");
        assertThat(resultOptional).contains("true");
        assertThat(resultOptional).containsIgnoringCase("1 main st, Chicago");

        String dateOfBirth = getDriver().findElement(By.xpath("//b[@name='dateOfBirth']")).getText();
        assertThat(dateOfBirth).isEqualTo("03/25/1989");

    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);

        LogEntries logs = getDriver().manage().logs().get("browser");

        System.out.println(">>>>> Browser logs. Begin:");

        for(LogEntry log : logs){
            System.out.println(log);
        }

        System.out.println(">>>>> Browser logs. End");
    }

    @And("I fill multi-select of the {string} and {string}")
    public void iFillMultiSelectOfTheAnd(String car1, String car2) throws InterruptedException {

//        WebElement carElement1 = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='" + car1 + "']"));
//        WebElement carElement2 = getDriver().findElement(By.xpath("//select[@name='carMake']/option[@value='" + car2 + "']"));
//
//        new Actions(getDriver()).click(carElement1)
//                                .keyDown(Keys.COMMAND)
//                                .click(carElement2)
//                                .perform();

        WebElement carElements = getDriver().findElement(By.xpath("//select[@name='carMake']"));

        Select carSelect = new Select(carElements);
        carSelect.selectByValue(car1);
        carSelect.selectByValue(car2);
    }

    @And("I {string} third party agreement")
    public void iThirdPartyAgreement(String action) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='thirdPartyButton']")).click();
        Thread.sleep(2000);
        if(action.equalsIgnoreCase("accept")){
            getDriver().switchTo().alert().accept();
        } else {
            getDriver().switchTo().alert().dismiss();
        }
        Thread.sleep(5000);
    }

    @And("fill out additional info with name {string} and phone {string}")
    public void fillOutAdditionalInfoWithNameAndPhone(String name, String phone) throws InterruptedException {

        getDriver().switchTo().frame("additionalInfo");

//        WebElement frame = getDriver().findElement(By.xpath("//iframe[contains(@src,'iframe')]"));
//        getDriver().switchTo().frame(frame);

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(name);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(phone);

        getDriver().switchTo().defaultContent();

    }

    @And("I verify {string} present on related docs page")
    public void iVerifyPresentOnRelatedDocsPage(String document) {

        String originalWindow = getDriver().getWindowHandle();
        getDriver().findElement(By.xpath("//button[contains(@onclick,'new')]")).click(); // after we click on this button, there will be two windows/tabs

//        getDriver().getWindowHandle();
//        getDriver().getWindowHandles(); // getWindowsHandles() - return 'set' where all the members are unique

        for (String handle : getDriver().getWindowHandles()){ // handle = newWindow
            getDriver().switchTo().window(handle);  // when we provide 'window()' method - we want to provide 'handle' (not the name) inside of it because it's more reliable way
        }  // this loop is switching to the last window/tab

        String docs = getDriver().findElement(By.xpath("//body")).getText();
        assertThat(docs).containsIgnoringCase(document);

        getDriver().close(); // closing the last tab/window. It's optional to close window

        getDriver().switchTo().window(originalWindow); // switching back to original window
    }
}

























