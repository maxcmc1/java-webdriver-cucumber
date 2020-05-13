package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UspsStepDefs {

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {

        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();

        getWait(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'calculateretailpostage')]")));

        getDriver().findElement(By.xpath("//a[contains(@href,'ZipLookupAction!')]")).click();

        getDriver().findElement(By.xpath("//a[contains(@class,'zip-code-address')]")).click();
    }

    @When("I go to Lookup ZIP page by address by mouseover")
    public void iGoToLookupZIPPageByAddressByMouseover() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        getActions().moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']//a")).click();

        getDriver().findElement(By.xpath("//a[contains(@class,'zip-code-address')]")).click();

    }

    @When("I go to Calculate Price Page by mouseover")
    public void iGoToCalculatePricePage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        getActions().moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//a[@role='menuitem'][text()='Calculate a Price']")).click();

    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePageByMouseover() {

        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();


        getWait(10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'calculateretailpostage')]")));

        getDriver().findElement(By.xpath("//a[contains(@href,'calculateretailpostage')]")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {

        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);

        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement stateInput = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(stateInput).selectByValue(state);

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {

        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        getWait().until(driver -> !resultElement.getText().isEmpty());

        String result = resultElement.getText();
        assertThat(result).containsIgnoringCase(zip);

    }

    @Then("I validate {string} zip code exists in each sub-result")
    public void iValidateZipCodeExistsInEachSubResult(String zipCode) {

        WebElement resultElement = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        getWait(10).until(driver -> !resultElement.getText().isEmpty());
//        getWait().until(driver -> resultElement.getText().length() > 0);
//        getWait().until(ExpectedConditions.textToBePresentInElement(resultElement, zipCode));

        List<WebElement> list = getDriver().findElements(By.xpath("//div[@class='zipcode-result-address']"));
        for (WebElement item : list) {
            String itemText = item.getText();
            System.out.println(itemText);
            assertThat(itemText).contains(zipCode);
        }

    }


    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String destination, String shape) {

        WebElement destinationInput = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        new Select(destinationInput).selectByVisibleText(destination);

        getDriver().findElement(By.xpath("//input[@value= '" + shape + "']")).click();

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
        getDriver().findElement(By.xpath("//input[@type='button']")).click();
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {

        String totalResult = getDriver().findElement(By.xpath("//div[@id='total']")).getText();
        assertThat(totalResult).contains(cost);

    }

    @When("I go to Find a Location Page")
    public void iGoToFindALocationPage() {
        WebElement mailAndShip = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));

        getActions().moveToElement(mailAndShip).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-find']//a")).click();

    }

    @And("I filter by {string} Location Types, {string} Services, {string} Available Services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String service, String available) {
        getDriver().findElement(By.xpath("//button[@id='post-offices-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + locationType + "']")).click();

        getDriver().findElement(By.xpath("//button[@id='service-type-select']")).click();
        getDriver().findElement(By.xpath("//a[text()='" + service + "']")).click();

        getDriver().findElement(By.xpath("//button[@id='available-service-select']")).click();
        getDriver().findElement(By.xpath("//a[string()='" + available + "']")).click();

    }

    @And("I fill in {string} street, {string} city, {string} state")
    public void iFillInStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();

        WebElement address = getDriver().findElement(By.xpath("//input[@id='addressLineOne']"));
        address.sendKeys(street);

        for (int i = 0; !address.getAttribute("value").equalsIgnoreCase(street) && i < 5; i++){
            address.clear();
            address.sendKeys(street);
        }

        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);

        WebElement stateInput = getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"));
        new Select(stateInput).selectByValue(state);

        getDriver().findElement(By.xpath("//div[contains(@class,'goto')]/a")).click();

    }

    @Then("I print the phone number and validate it is {string}")
    public void iPrintThePhoneNumberAndValidateItIs(String phone) throws InterruptedException {

        getDriver().findElement(By.xpath("//div[@id='resultBox']/div[1]")).click();

        String actualPhone = getDriver().findElement(By.xpath("//p[@id='detailTollFree']")).getText();
        assertThat(actualPhone).contains(phone);

    }

    @When("I go to {string} tab")
    public void iGoToTab(String menuItem) throws InterruptedException {

        By locator = By.xpath("//a[@class='menuitem'][text()='" + menuItem + "']");
        getDriver().findElement(locator).click();

    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String textInput) throws InterruptedException {

//        getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search')]")).sendKeys(textInput);
//
//        getDriver().findElement(By.xpath("//button[contains(text(),'Search')]")).click();

        WebElement searchInput = getDriver().findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
        searchInput.sendKeys(textInput + Keys.RETURN);

    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String textInput) throws InterruptedException {

        By locator = By.xpath("//ul[@class='slds-has-dividers--bottom']");
        String fromText = getDriver().findElement(locator).getText();
        assertThat(fromText).doesNotContain(textInput);

    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String tabOne, String tabTwo) throws InterruptedException {

        By locatorOne = By.xpath("//a[@class='menuitem'][text()='" + tabTwo + "']");
        WebElement businessTab = getDriver().findElement(locatorOne);

        getActions().moveToElement(businessTab).perform();

        By locatorTwo = By.xpath("//a[contains(text(),'" + tabOne + "')]");
        getDriver().findElement(locatorTwo).click();

    }

    @And("I search for {string}")
    public void iSearchFor(String address) {

        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//button[contains(@class,'icon-search')]")).click();
        ; // or using unicode value: searchInput.sendKeys(address + "\ue006");
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String button) throws InterruptedException {
        WebElement overlay = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        getWait(10).until(ExpectedConditions.visibilityOf(overlay));
        getWait(10).until(ExpectedConditions.invisibilityOf(overlay));
        getDriver().findElement(By.xpath("//a[contains(text(),'" + button + "')]")).click();

    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String button) throws InterruptedException {

        By locator = By.xpath("//div[@id='route-table']//a[contains(text(),'" + button + "')]");

        WebElement selectAll = getDriver().findElement(locator);

        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));

        selectAll.click();

    }

    @And("I close modal window")
    public void iCloseModalWindow() {

        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();

    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        // initially we have not all elements (25 elements)
        // we need to scroll to the last element so more of them loaded (infinite scroll)
        // we get the number of total expected elements
        String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class,'totalsArea')]")).getText();
        int totalCountInt = Integer.parseInt(totalCountString.replaceAll("\\D*", "")); // "\\D*" - 'Regex' is used for manipulating with strings
                                                                                                                // parsing extracted number from the whole string into integer
        // getting locator of table cell list
        By costListSelector = By.xpath("//td[@idx='7']");

        // find current element list on the page
        List<WebElement> costList = getDriver().findElements(costListSelector);

        // get last element from the current costList (25th element)
        int lastIndex = costList.size() -1;
        WebElement lastInList = costList.get(lastIndex);

        // we scroll to the current last element
        getActions().moveToElement(lastInList).perform();

        // wait until total number of elements loaded
        getWait().until(ExpectedConditions.numberOfElementsToBe(costListSelector, totalCountInt));


        costList = getDriver().findElements(costListSelector);

//        Locale locale = new Locale("en", "US");
//        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        double actualTotal = 0; // total of all costs
        for (WebElement cost : costList){
            String costString = cost.getText().replace("$", "");
            double costTotal = Double.parseDouble(costString);

//            double costTotal = format.parse(cost.getText()).doubleValue();

            actualTotal += costTotal;
        }

        System.out.println("Actual total: " + actualTotal);

        String expectedTotalCostString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        double expectedTotal = Double.parseDouble(expectedTotalCostString);
        System.out.println("Expected total: " + expectedTotal);

        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));

    }

    //=============================================================================================================


    @When("I perform {string} search")
    public void iPerformSearch(String textInput) throws InterruptedException {

        By locatorOne = By.xpath("//li[contains(@class,'nav-search')]");
        WebElement searchIcon = getDriver().findElement(locatorOne);

        By locatorTwo = By.xpath("//input[@id='global-header--search-track-search']");
        WebElement searchInput = getDriver().findElement(locatorTwo);

        getActions().moveToElement(searchIcon)
                    .sendKeys(searchInput,textInput + Keys.RETURN)
                    .perform();


    }

    @And("I set {string} in filters")
    public void iSetInFilters(String filterTab) throws InterruptedException {

        By locator = By.xpath("//div[@class='white-spinner-container']");

        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));

        getDriver().findElement(By.xpath("//a[contains(@title,'" + filterTab + "')]")).click();

        getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    @Then("I verify that {string} results found")
    public void iVerifyThatResultsFound(String count) throws InterruptedException {
        String heading = getDriver().findElement(By.xpath("//span[@id='searchResultsHeading']")).getText();

        String headingCount = heading.replaceAll("\\D*", ""); // "\\D*" - 'Regex' is used for manipulating with strings

        int parsedActualCount = Integer.parseInt(headingCount); // parsing extracted number from the whole string into integer
        int parsedExpectedCount = Integer.parseInt(count);
        assertThat(parsedActualCount).isEqualTo(parsedExpectedCount);

        List<WebElement> results = getDriver().findElements(By.xpath("//ul[@id='records']/li"));
        int resultCount = results.size(); // when it's 'List' - we can take size as how many elements in it
        assertThat(resultCount).isEqualTo(parsedExpectedCount);


    }

    @When("I select {string} in results")
    public void iSelectInResults(String searchResult) throws InterruptedException {

        By locator = By.xpath("//span[contains(text(),'" + searchResult + "')]");

        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));

        getDriver().findElement(locator).click();

    }

    @And("I click {string} button")
    public void iClickButton(String button) throws InterruptedException {

        By locator = By.xpath("//a[contains(text(),'" + button + "')][@target='_blank']");

        By locator2 = By.xpath("//div[contains(text(),'Feedback')]");

        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator2));

        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));

        getDriver().findElement(locator).click();

    }

    @Then("I validate that {string} is required")
    public void iValidateThatSignInIsRequired(String text) throws InterruptedException {

        String originalTab = getDriver().getWindowHandle();

        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }

        getWait(10).until(ExpectedConditions.titleContains("Sign In"));
        WebElement username = getDriver().findElement(By.xpath("//input[@name='username']"));
        assertThat(username.isDisplayed()).isTrue();
        getDriver().switchTo().window(originalTab);

    }

    @And("I work with multiple windows")
    public void iWorkWithMultipleWindows() {
        // click on mail & ship
        WebElement mail = getDriver().findElement(By.id("mail-ship-width"));
        getActions()
                .moveToElement(mail)
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .perform();


        // switch to new window
        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));

        Set<String> originWindows = getDriver().getWindowHandles();

        // click button
        getDriver().findElement(By.xpath("//p/a[contains(@href,'cns')]")).click();

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
        WebElement manage = getDriver().findElement(By.xpath("//li[@class='menuheader']/a[contains(@href,'manage/')]"));
        getActions()
                .moveToElement(manage)
                .keyDown(Keys.COMMAND)
                .click()
                .keyUp(Keys.COMMAND)
                .perform();

        // switch to new window
        getDriver().getWindowHandles().forEach(h -> getDriver().switchTo().window(h));

        //check element visible
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("track-package--input")));

        // switch to first window
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());

    }
}
