@converter
Feature: Converter steps

  @converter1
  Scenario Outline: Validate unit converters
    Given I go to "converter" page
    When I click on "<Units>"
    And I set "<From Unit Type>" to "<To Unit Type>"
    Then I enter into From field "<From Value>" and verify "<To Value>" result
    Examples:
      | Units       | From Unit Type | To Unit Type     | From Value | To Value |
      | Length      | Kilometer      | Mile             | 100        | 62       |
      | Temperature | Fahrenheit     | Celsius          | 54         | 12       |
      | Area        | Square Mile    | Square Kilometer | 100        | 258      |
      | Weight      | Pound          | Kilogram         | 120        | 54       |
      | Time        | Week           | Minute           | 1          | 10080    |


  @calculator1
  Scenario: Verify calculator result
    Given I go to "calculator" page
    When I navigate to "Auto Loan Calculator"
    And I clear all calculator fields
    And I calculate
    Then I verify "Please provide a positive auto price." calculator error
    Then I verify "Please provide a positive interest value." calculator error
    And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    And I calculate
    Then I verify monthly pay is "$372.86"