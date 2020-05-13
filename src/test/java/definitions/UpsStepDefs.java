package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UpsStepDefs {
    @And("I open Shipping menu")
    public void iOpenShippingMenu() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[@id='ups-header_logo']//img")).click();

        WebElement quickStart = getDriver().findElement(By.xpath("//a[@id='ups-quickStartMenu']"));
        WebElement dropdown = getDriver().findElement(By.xpath("//div[@id='ups-quickStartPanel']"));
        for (int i = 0; dropdown.isDisplayed() && i < 1; i++){
            quickStart.click();
        }

        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks1']")).click();

    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment:')]")).click();

    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {

        getDriver().findElement(By.xpath("//select[@id='origincountry']/option[text()='United States']")).click();
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys("Administrator");
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys("4970 El Camino Real");
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys("94022");
        getDriver().findElement(By.xpath("//input[@id='origincity']")).sendKeys("Santa Clara");
        getDriver().findElement(By.xpath("//select[@id='originstate']/option[text()='California']")).click();
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("mail@example.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("1234567890");

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {

        WebElement element= getDriver().findElement(By.xpath("//button[contains(@id,'ContinueButton')]"));
        getExecutor().executeScript("arguments[0].click();", element);

    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() throws InterruptedException {

        String header = getDriver().findElement(By.xpath("//div[@class='ups-group ups-group_condensed']")).getText();
        assertThat(header).containsIgnoringCase("4970 El Camino Real");

    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() throws InterruptedException {


        WebElement element= getDriver().findElement(By.xpath("//button[contains(@id,'CancelShipmentButton')]"));
        getExecutor().executeScript("arguments[0].click();", element);

        getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']")).click();


    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() throws InterruptedException {

        String header = getDriver().findElement(By.xpath("//h2[contains(@class,'ups-centered_header')]")).getText();
        assertThat(header).containsIgnoringCase("Where are you shipping from?");

    }


    //============================================================================================================================================================================================================


    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {

        getDriver().findElement(By.xpath("//select[@id='destinationcountry']/option[text()='United States']")).click();
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys("John Doe");
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys("870 7th Ave");

        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys("10019");

        WebElement cityValue = getDriver().findElement(By.xpath("//input[@id='destinationcity']"));
        getWait().until(ExpectedConditions.attributeToBeNotEmpty(cityValue, "value"));

        WebElement stateElement = getDriver().findElement(By.xpath("//select[@id='destinationstate']/option[text()='California']"));
        getWait().until(driver -> !stateElement.getText().isEmpty());


    }

    @And("I set packaging type")
    public void iSetPackagingType() throws InterruptedException {

        getDriver().findElement(By.xpath("//select[contains(@id,'TypeDropdown')]/option[contains(text(),'Small')]")).click();

        Thread.sleep(3000);

        getDriver().findElement(By.xpath("//input[contains(@id,'nbsPackagePackageWeight')]")).sendKeys("1");

    }

    @Then("I verify total charges")
    public void iVerifyTotalCharges() throws InterruptedException {


        WebElement totalCharges = getDriver().findElement(By.xpath("//span[contains(string(),'Total Charges:')]"));
        getWait().until(driver -> !totalCharges.getText().isEmpty());

    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() throws InterruptedException {

        WebElement lowest = getDriver().findElement(By.xpath("//p[@id='nbsServiceTileServiceDescription0_1_1']"));
        getExecutor().executeScript("arguments[0].click();", lowest);

    }

    @And("I set Saturday Delivery type")
    public void iSetSaturdayDeliveryType() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("test");

        getDriver().findElement(By.xpath("//label[contains(@for,'nbsSaturdayDelivery')]//span[@class='ups-lever_switch_bg']")).click();

    }


    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {

        getDriver().findElement(By.xpath("//div[@id='tile-4']")).click();

        String payPal = getDriver().findElement(By.xpath("//label[contains(text(),'PayPal ')]")).getText();

        assertThat(payPal).containsIgnoringCase("PayPal");

    }

    @And("I review the shipment form")
    public void iReviewTheShipmentForm() throws InterruptedException {

        Thread.sleep(3000);

        By locator = By.xpath("//span[@class='button-spinner']");

        getWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));

        getDriver().findElement(locator).click();


//        WebElement lowest = getDriver().findElement(By.xpath("//button[@id='nbsBackForwardNavigationReviewPrimaryButton']"));
//        getExecutor().executeScript("arguments[0].click();", lowest);


    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {

//        getDriver().findElement(By.xpath("//input[@id='termsAndConditionsCheckbox']")).click();

        WebElement lowest = getDriver().findElement(By.xpath("//input[@id='termsAndConditionsCheckbox']"));
        getExecutor().executeScript("arguments[0].click();", lowest);
    }
}
