@usps
Feature: UPS test suite

  @ups1
  Scenario: UPS end to end
    Given I go to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset


  @ups2
  Scenario: UPS end to end2
    Given I go to "ups" page
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    When I fill out destination shipment fields
    When I submit the shipment form
    And I set packaging type
    Then I verify total charges
    When I submit the shipment form
    And I select cheapest delivery option
    And I submit the shipment form
    And I set Saturday Delivery type
    Then I verify total charges
    When I submit the shipment form
    And I select Paypal payment type
    And I review the shipment form
    Then I review all recorded details on the review page
    And I cancel the shipment form
    Then I verify shipment form is reset