@market

Feature: Marketing app test suite

  @market1
  Scenario: Market basic test
    And I go to "quote" page
    When I fill out required fields
    And I verify email field behavior
    And I submit the form
#    Then I verify that fields values recorded correctly

  @market2
  Scenario: Market optional fields
    Given I go to "quote" page
    When I fill out required fields
    And I fill out optional fields
    And I submit the form
    Then I verify optional fields


  @market3
  Scenario: Printing logs
    Given I go to "yahoo" page
    And I print logs to the console

  @market4
  Scenario: Multi-select
    Given I go to "quote" page
    And I fill multi-select of the "Toyota" and "BMW"


  @market5
  Scenario: Quote alert
    Given I go to "quote" page
    And I "dismiss" third party agreement

  @market6
  Scenario: Additional info (iframe)
    Given I go to "quote" page
    And fill out additional info with name "John Doe" and phone "777777755"
    And I fill out required fields
    And I submit the form

    @market7
      Scenario: Related docs (switching to new tab/window)
      Given I go to "quote" page
      And I verify "Document 2" present on related docs page
      And I fill out optional fields



  @quote1
  Scenario: Base scenario
    Given I go to "quote" page
    And I print page details in console
    When I fill out required fields
    And I submit the form






