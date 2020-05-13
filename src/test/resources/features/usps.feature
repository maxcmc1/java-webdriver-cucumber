@usps
Feature: USPS test suite

  @usps1
  Scenario Outline: Validate ZIP codes
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street                 | city          | state | zip   |
      | 4970 El Camino Real    | Los Altos     | CA    | 94022 |
      | 111 McInnis Pkwy       | San Rafael    | CA    | 94903 |
      | 1600 Amphitheatre Pkwy | Mountain View | CA    | 94043 |

  @usps1.2
  Scenario: Validate ZIP code for Portnov Computer School using mouseover
    Given I go to "usps" page
    When I go to Lookup ZIP page by address by mouseover
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result


  @usps3
  Scenario: Verify that zip code is not just in result area, but each sub-result row element has the correct zip code for Portnov Computer School
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in each sub-result

  @usps4
  Scenario: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select "United Kingdom (United Kingdom of Great Britain and Northern Ireland)" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"

  @usps4.1
  Scenario: Calculate price using mouseover
    Given I go to "usps" page
    When I go to Calculate Price Page by mouseover
    And I select "United Kingdom (United Kingdom of Great Britain and Northern Ireland)" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"


  @usps5
  Scenario: Phone number of the nearest Accountable Mail Pickup Service Post Office for Portnov Computer School
    Given I go to "usps" page
    When I go to Find a Location Page
    And I filter by "Post Offices™" Location Types, "Pickup Services" Services, "Accountable Mail" Available Services
    And I fill in "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    Then I print the phone number and validate it is "800-275-8777"

  @usps6
  Scenario: Quadcopters delivery
    Given I go to "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search


  @usps7
  Scenario: Every door direct mail
    Given I go to "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I click "Show Table" on the map
    When I click "Select All" on the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @usps8
  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Mail & Ship" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that "Sign In" is required


  @usps9
  Scenario: Multiple windows
    Given I go to "usps" page
    And I work with multiple windows


