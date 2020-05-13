package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class QuoteStepDefsOOP {


    @And("I go to {string} page oop")
    public void iGoToPageOop(String page) {

        QuoteForm form = new QuoteForm();
        form.open();

    }

    @When("I fill out required fields with {string} role credentials oop")
    public void iFillOutRequiredFieldsWithRoleCredentialsOop(String role) {

        Map<String, String> user = getData(role);

        QuoteForm form = new QuoteForm();
        form.fillUsername(user.get("username"));
        form.fillUserEmail(user.get("email"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.fillPassword(user.get("password"));
        form.fillConfirmPassword(user.get("password"));
        form.clickPrivacyCheckBox();

    }


    @And("I submit the form oop")
    public void iSubmitTheFormOop() {

        QuoteForm form = new QuoteForm();
        form.clickSubmitButton();

    }

    @Then("I verify required fields with {string} role credentials oop")
    public void iVerifyRequiredFieldsWithRoleCredentialsOop(String role) {

        Map<String, String> user = getData(role);

        QuoteResult result = new QuoteResult();
        assertThat(result.getResultForm()).contains(user.get("username"));
        assertThat(result.getResultForm()).contains(user.get("email"));
        assertThat(result.getResultForm()).doesNotContain(user.get("password"));
        assertThat(result.getResultForm()).contains(user.get("firstName"));
        assertThat(result.getResultForm()).contains(user.get("lastName"));
        assertThat(result.getAgreedPrivacy()).isEqualTo("true");
        assertThat(result.getPassword()).isEqualTo("[entered]");

    }

//    @When("I clear {string} field")
//    public void iClearFieldOfRole(String field) {
//
//        QuoteForm form = new QuoteForm();
//        switch (field){
//            case "username":
//                form.clearUserName();
//                break;
//            case "email":
//                form.clearEmail();
//                break;
//            case "confirmPassword":
//                form.clearConfirmPassword();
//                break;
//            case "password":
//                form.clearPassword();
//                break;
//            case "name":
//                form.clearName();
//                break;
//            default:
//                throw new RuntimeException("Unknown field: " + field);
//
//        }
//    }

    @When("I clear {string} field")
    public void iClearField(String field) {

        QuoteForm form = new QuoteForm();

        form.clearFieldEl(field);
    }


    @And("I uncheck {string} field")
    public void iUncheckFieldOfRole(String checkBox) {

        QuoteForm form = new QuoteForm();

        switch (checkBox){
            case "agreedToPrivacyPolicy":
                form.clickPrivacyCheckBox();
                break;
            default:
                throw new RuntimeException("Unknown field: " + checkBox);

        }

    }


    @And("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String expectedMessage) {

        QuoteForm form = new QuoteForm();

        String actualMessage = form.getErrorText(field);
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }


    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String filed, String value) {

        QuoteForm form = new QuoteForm();
        switch (filed){
            case "username":
                form.fillUsername(value);
                break;
            case "email":
                form.fillUserEmail(value);
                break;
            case "password":
                form.fillPassword(value);
                break;
            case "confirmPassword":
                form.fillConfirmPassword(value);
                break;
            default:
                throw new RuntimeException("Unknown field " + filed);
        }

    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {

        QuoteForm form = new QuoteForm();

        assertThat(form.isErrorDisplayed(field)).isFalse();

    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {

        QuoteForm form = new QuoteForm();
        form.fillName(firstName, lastName);

    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String fieldName, String expectedValue) {

        QuoteForm form = new QuoteForm();

        String actualValue = form.getFieldValue(fieldName);
        assertThat(actualValue).isEqualTo(expectedValue);
    }


    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {

        QuoteForm form = new QuoteForm();

        form.fillNameWithMiddleName(firstName, middleName, lastName);
        System.out.println();

    }
}
