@quote

Feature: Marketing app test suite oop

  @quote1
  Scenario Outline: Market basic test oop
    And I go to "quote" page oop
    When I fill out required fields with "<role>" role credentials oop
    And I submit the form oop
    Then I verify required fields with "<role>" role credentials oop
    Examples:
    |role   |
    | user  |
    | admin |


  @quote2
  Scenario Outline: Required fields test oop
    Given I go to "quote" page oop
    When I fill out required fields with "<role>" role credentials oop
    When I clear "username" field
    And I clear "email" field
    And I clear "confirmPassword" field
    And I clear "password" field
    And I clear "name" field
    And I uncheck "agreedToPrivacyPolicy" field
    And I submit the form oop
    Then I see "username" error message "This field is required."
    And I see "email" error message "This field is required."
    And I see "password" error message "This field is required."
#    And I see "confirmPassword" error message "This field is required." //based on this scenario - this filed will not generate any error message
    And I see "name" error message "This field is required."
    And I see "agreedToPrivacyPolicy" error message "- Must check!"
    Examples:
      |role   |
      | user  |
      | admin |


  @quote3
  Scenario: Market username test oop
    Given I go to "quote" page oop
    When I fill out "username" field with "a"
    And I submit the form oop
    Then I see "username" error message "Please enter at least 2 characters."
    And I clear "username" field
    When I fill out "username" field with "ab"
    Then I don't see "username" error message


  @quote4
  Scenario Outline: Market email test oop
    Given I go to "quote" page oop
    When I fill out "email" field with "invalid"
    And I submit the form oop
    Then I see "email" error message "Please enter a valid email address."
    And I clear "email" field
    When I fill out "email" field with "<email value>"
    Then I don't see "email" error message
    Examples:
      | email value |
      | max@example.com  |
      | alex@example.com |


  @quote5
  Scenario: Market passwords test oop
    Given I go to "quote" page oop
    When I fill out "password" field with "1234"
    And I submit the form oop
    Then I see "password" error message "Please enter at least 5 characters."
    And I clear "password" field
    When I fill out "password" field with "12345"
    Then I don't see "password" error message
    When I fill out "confirmPassword" field with "1234"
    And I submit the form oop
    Then I see "confirmPassword" error message "Please enter at least 5 characters."
    And I clear "confirmPassword" field
    When I fill out "confirmPassword" field with "54321"
    Then I see "confirmPassword" error message "Passwords do not match!"
    And I clear "confirmPassword" field
    When I fill out "confirmPassword" field with "12345"
    Then I don't see "confirmPassword" error message


  @quote6
  Scenario: Market name test oop
    Given I go to "quote" page oop
    When I fill out name field with first name "John" and last name "Doe"
    Then I verify "name" field value "John Doe"
    When I fill out name field with first name "John", middle name "Richard", last name "Doe"
    Then I verify "name" field value "John Richard Doe"