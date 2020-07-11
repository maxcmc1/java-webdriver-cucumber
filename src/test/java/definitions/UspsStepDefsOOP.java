package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class UspsStepDefsOOP {

    @Given("I go to {string} page")
    public void iGoToPage(String page) {

        LandingUspsPage landingUspsPage = new LandingUspsPage();

        switch (page){
            case "usps":
                landingUspsPage.open();
                break;
            default:
                throw new RuntimeException("Page not supported: " + page);
        }

    }



    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {

        UspsHeader uspsHeader = new UspsHeader();

        uspsHeader.clickMailAndShip()
                .clickLookUpZipCode()
                .clickZipCodeAddress();

    }


    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {

        UspsZipCodeByAddress uspsZipCodeByAddress = new UspsZipCodeByAddress();

        uspsZipCodeByAddress.fillAddress(street, city, state);

    }


    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {

        UspsZipCodeByAddress uspsZipCodeByAddress = new UspsZipCodeByAddress();

        assertThat(uspsZipCodeByAddress.result()).containsIgnoringCase(zip);

    }

    @When("I go to Lookup ZIP page by address by mouseover")
    public void iGoToLookupZIPPageByAddressByMouseover() {

        UspsHeader uspsHeader = new UspsHeader();
        LookUpZipCodePage lookUpZipCodePage = new LookUpZipCodePage();

        uspsHeader.mouseOverMailAndShip();
        lookUpZipCodePage.clickZipCodeAddress();

    }

    @Then("I validate {string} zip code exists in each sub-result")
    public void iValidateZipCodeExistsInEachSubResult(String zip) {

        UspsZipCodeByAddress uspsZipCodeByAddress = new UspsZipCodeByAddress();

        List<WebElement> list = uspsZipCodeByAddress.subResult();
        for (WebElement item : list) {
            String itemText = item.getText();
            System.out.println(itemText);
            assertThat(itemText).contains(zip);
        }

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePageByMouseover() {

        UspsHeader uspsHeader = new UspsHeader();

        uspsHeader.clickMailAndShip()
                .clickCalculatePrice();

    }


    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {

        PostagePriceCalculator postagePriceCalculator = new PostagePriceCalculator();

        postagePriceCalculator.providingDestinationAndShape(destination, shape);

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {

        RetailPostagePriceCalculatorPostcard retailPostagePriceCalculatorPostcard = new RetailPostagePriceCalculatorPostcard();

        retailPostagePriceCalculatorPostcard.definingQuantity(quantity);

    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {

        RetailPostagePriceCalculatorPostcard retailPostagePriceCalculatorPostcard = new RetailPostagePriceCalculatorPostcard();

        String totalResult = retailPostagePriceCalculatorPostcard.getTotalCost();
        assertThat(totalResult).contains(cost);

    }

    @When("I go to Calculate Price Page by mouseover")
    public void iGoToCalculatePricePage() {

        UspsHeader uspsHeader = new UspsHeader();

        uspsHeader.mouseOverCalculatePrice();

    }

    @When("I go to Find a Location Page")
    public void iGoToFindALocationPage() {

        UspsHeader uspsHeader = new UspsHeader();
        uspsHeader.navigatingToFindLocationPage();

    }

    @And("I filter by {string} Location Types, {string} Services, {string} Available Services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String service, String available) {

        FindLocations findLocations = new FindLocations();
        findLocations.filteringServices(locationType, service, available);

    }

    @And("I fill in {string} street, {string} city, {string} state")
    public void iFillInStreetCityState(String street, String city, String state) {

        FindLocations findLocations = new FindLocations();
        findLocations.fillingFullAddress(street, city, state);

    }

    @Then("I print the phone number and validate it is {string}")
    public void iPrintThePhoneNumberAndValidateItIs(String phone) {

        FindLocations findLocations = new FindLocations();

        String actualPhone = findLocations.getTextPhoneNumber();
        assertThat(actualPhone).contains(phone);

    }

    @When("I go to {string} tab")
    public void iGoToTab(String menuItem){

        UspsHeader uspsHeader = new UspsHeader();
        uspsHeader.navigateToLandPageTabs(menuItem);
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String text){

        UspsHelpSearchPage uspsHelpSearchPage = new UspsHelpSearchPage();
        uspsHelpSearchPage.searchText(text);

    }


    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String text){

        UspsHelpSearchPage uspsHelpSearchPage = new UspsHelpSearchPage();

        String fromText = uspsHelpSearchPage.getFormText();
        assertThat(fromText).doesNotContain(text);

    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String tabOne, String tabTwo){

        UspsHeader uspsHeader = new UspsHeader();
        uspsHeader.navigateToLandPageTabsByMouseOver(tabTwo);
        uspsHeader.navigateToLandPageTabs(tabOne);

    }

    @And("I search for {string}")
    public void iSearchFor(String address) {

        UspsEveryDoorDirectMailPage uspsEveryDoorDirectMailPage = new UspsEveryDoorDirectMailPage();
        uspsEveryDoorDirectMailPage.searchAddress(address);

         // or using unicode value: searchInput.sendKeys(address + "\ue006");
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button){

        UspsEveryDoorDirectMailPage uspsEveryDoorDirectMailPage = new UspsEveryDoorDirectMailPage();
        uspsEveryDoorDirectMailPage.showTheTable(button);

    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String button) {

        UspsEveryDoorDirectMailPage uspsEveryDoorDirectMailPage = new UspsEveryDoorDirectMailPage();
        uspsEveryDoorDirectMailPage.selectAllRecords(button);

    }

    @And("I close modal window")
    public void iCloseModalWindow() {

        UspsEveryDoorDirectMailPage uspsEveryDoorDirectMailPage = new UspsEveryDoorDirectMailPage();
        uspsEveryDoorDirectMailPage.closingModalWindow();
    }


    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() {

        UspsEveryDoorDirectMailPage uspsEveryDoorDirectMailPage = new UspsEveryDoorDirectMailPage();
        uspsEveryDoorDirectMailPage.getSummaryOfAllRows();

    }

    @When("I perform {string} search")
    public void iPerformSearch(String textInput) {

        UspsHeader uspsHeader = new UspsHeader();
        uspsHeader.sendingText(textInput);

    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterTab){

        UspsSearchResultPage uspsSearchResultPage = new UspsSearchResultPage();
        uspsSearchResultPage.iSetInFilters(filterTab);

    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String count) {

        UspsMailAndShipFilterPage uspsMailAndShipFilterPage = new UspsMailAndShipFilterPage();

        String headingCount = uspsMailAndShipFilterPage.getHeadingText().replaceAll("\\D*", ""); // "\\D*" - 'Regex' is used for manipulating with strings

        int parsedActualCount = Integer.parseInt(headingCount); // parsing extracted number from the whole string into integer
        int parsedExpectedCount = Integer.parseInt(count);
        assertThat(parsedActualCount).isEqualTo(parsedExpectedCount);

        int resultCount = uspsMailAndShipFilterPage.getAllResultsList().size(); // when it's 'List' - we can take size as how many elements in it
        assertThat(resultCount).isEqualTo(parsedExpectedCount);

    }

    @When("I select {string} in results")
    public void iSelectInResults(String searchResult){

        UspsMailAndShipFilterPage uspsMailAndShipFilterPage = new UspsMailAndShipFilterPage();
        uspsMailAndShipFilterPage.getSelectInResults(searchResult);

    }

    @And("I click {string} button")
    public void iClickButton(String button) {

        UspsPriorityMail uspsPriorityMail = new UspsPriorityMail();
        uspsPriorityMail.clickShipNowButton(button);

    }

    @Then("I validate that {string} is required")
    public void iValidateThatSignInIsRequired(String text) {

        UspsSignInToYourAccount uspsSignInToYourAccount = new UspsSignInToYourAccount();

        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        getWait(10).until(ExpectedConditions.titleContains(text));
        assertThat(uspsSignInToYourAccount.getUsername().isDisplayed()).isTrue();
        getDriver().switchTo().window(uspsSignInToYourAccount.getWindowHandle());

    }

    @And("I work with multiple windows")
    public void iWorkWithMultipleWindows() {

        UspsHeader uspsHeader = new UspsHeader();
        UspsMailAndShipPage uspsMailAndShipPage = new UspsMailAndShipPage();
        UspsTrackAndManagePage uspsTrackAndManagePage = new UspsTrackAndManagePage();

        // click on mail & ship and open in new window
        uspsHeader.openMailAndShipInNewWindow();


        // switch to new window
        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));

        Set<String> originWindows = getDriver().getWindowHandles();

        // click button
        uspsMailAndShipPage.clickPrintLabelButton();

        Set<String> newWindows = getDriver().getWindowHandles();

        newWindows.removeAll(originWindows);
        String newHandle = newWindows.iterator().next();

        getDriver().switchTo().window(newHandle);


        // switch to new window
//        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));


        getWait().until(ExpectedConditions.titleContains("Sign In"));

        // switch to first window
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());

        // click track and manage
        uspsHeader.openTrackAndManageNewWindow();


        // switch to new window
        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));

        //check element visible
        uspsTrackAndManagePage.waitUntilTrackYourPackage();

        // switch to first window
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());

    }

}
