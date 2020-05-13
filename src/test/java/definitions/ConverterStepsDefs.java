package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConverterStepsDefs {

    @When("I click on {string}")
    public void iClickOn(String unit) throws InterruptedException {
        
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + unit + "']")).click();

    }

    @And("I set {string} to {string}")
    public void iSetTo(String unitOne, String unitTwo) throws InterruptedException {
        WebElement fromForm = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        new Select(fromForm).selectByVisibleText(unitOne);

        WebElement toForm = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        new Select(toForm).selectByVisibleText(unitTwo);

    }

    @Then("I enter into From field {string} and verify {string} result")
    public void iEnterIntoFromFieldAndVerifyResult(String numberFrom, String numberTo) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(numberFrom);

        String toInput = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(toInput).contains(numberTo);

    }

    //==============================================================================================================================================================================================


    @When("I navigate to {string}")
    public void iNavigateTo(String link) {

         getDriver().findElement(By.xpath("//a[contains(text(),'" + link + "')]")).click();

    }
    

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();

        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();

        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();

        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();

        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();

        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();

        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();
        
    }
    

    @And("I calculate")
    public void iCalculate() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@type='image'][@value='Calculate']")).click();

        Thread.sleep(2000);

    }


    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String actualErrorText) {

       String expectedErrorText =  getDriver().findElement(By.xpath("//a[@name='autoloanresult']/..")).getText();
       assertThat(expectedErrorText).containsIgnoringCase(actualErrorText);

    }


    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String autoPrice, String loanTerm, String interestRate, String downPayment, String tradeInValue, String state, String salesTax, String otherFees) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(autoPrice);

        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(loanTerm);

        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interestRate);

        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downPayment);

        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeInValue);

        WebElement stateOption = getDriver().findElement(By.xpath("//select[@name='cstate']"));
        new Select(stateOption).selectByVisibleText(state);

        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(salesTax);

        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(otherFees);

    }


    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String amount) {

        String payment = getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText();
        assertThat(payment).containsIgnoringCase(amount);

    }

}
