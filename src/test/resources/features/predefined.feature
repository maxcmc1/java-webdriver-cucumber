@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title contains "Google"
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    And I wait for element with xpath "//*[@class='g']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title contains "Yahoo"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='header-search-input']"
    And I click on element with xpath "//*[contains(@id,'header-desktop')]"
    And I wait for element with xpath "//li" to be present
    Then element with xpath "//*[@id='left']" should contain text "cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title contains "Bing"
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element with xpath "//*[@for='sb_form_go']"
    And I wait for element with xpath "//*[@class='b_caption']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title contains "Gibiru"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='q']"
    And I click on element with xpath "//*[@id='button-addon2']"
    And I wait for element with xpath "//*[contains(@class,'gsc-webResult')]" to be present
    Then element with xpath "//*[@id='___gcse_0']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='search_form_input_homepage']"
    And I click on element with xpath "//*[@id='search_button_homepage']"
    And I wait for element with xpath "//*[contains(@id,'r1')]" to be present
    Then element with xpath "//*[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    When I type "Behavior Driven Development" into element with xpath "//*[@type='text'][@name='query']"
    And I click on element with xpath "//*[@class='search-submit']"
    And I wait for element with xpath "//article" to be present
    Then element with xpath "//*[@class='page-results']" should contain text "cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com/"
    Then I should see page title contains "Encrypt"
    When I type "BDD" into element with xpath "(//input[@name='q'])[1]"
    And I click on element with xpath "(//*[@id='btn-secure-search'])[1]"
    And I wait for element with xpath "//*[@class='web-result unloaded']" to be present
    Then element with xpath "//*[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    And I should see page title contains "Startpage"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='query']"
    And I click on element with xpath "//*[contains(@class,'search-form__button-icon')]"
    And I wait for element with xpath "//*[@class='w-gl__result']" to be present
    And I wait for element with xpath "//*[@class='w-gl__result']" to be clickable
    Then element with xpath "//*[@class='mainline-results--default']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='text']"
    And I click on element with xpath "//*[@role='button'][@type='submit']"
    And I wait for element with xpath "//li" to be present
    Then element with xpath "//*[@class='content__left']" should contain text "Driven"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://www.boardreader.com/"
    Then I should see page title contains "Boardreader"
    When I type "Behavior Driven Development" into element with xpath "//*[@id='title-query']"
    And I click on element with xpath "//*[@id='title-submit']"
    And I wait for element with xpath "//li" to be present
    Then element with xpath "//*[contains(@class,'searchResultsBlock')]//*[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
    And I click on element with xpath "//*[@type='submit']"
    And I wait for element with xpath "//*[@class='result-body']" to be present
    Then element with xpath "//*[@class='mainline-results']" should contain text "Driven"


  @predefined12
  Scenario: Predefined steps for Amazon
    Given I open url "https://www.amazon.com/"
    Then I should see page title contains "Amazon"
    When I type "dash camera" into element with xpath "//*[@name='field-keywords']"
    And I click on element with xpath "//*[@type='submit'][@class='nav-input']"
    And I wait for element with xpath "//*[@data-component-type='s-impression-logger']" to be present
    Then element with xpath "//*[@ id='search']" should contain text "Camera"
    And I click on element with xpath "//*[@data-component-id='1']/..//*[@class='a-section aok-relative s-image-fixed-height']"
    And I wait for element with xpath "//*[@id='productTitle']" to be present
    Then element with xpath "//*[@id='productTitle']" should contain text "Camera"

  @predefined13
  Scenario: Predefined steps for Ebay
    Given I open url "https://www.ebay.com/"
    Then I should see page title contains "eBay"
    When I type "phone case" into element with xpath "//*[@id='gh-ac']"
    And I click on element with xpath "//*[@id='gh-btn']"
    And I wait for element with xpath "//*[@class='s-item__info clearfix']" to be present
    Then element with xpath "//*[@class='srp-results srp-list clearfix']" should contain text "phone"
    And I click on element with xpath "(//*[@class='s-item__image-img'])[1]"
    And I wait for element with xpath "//*[@id='itemTitle']" to be present
    Then element with xpath "//*[@id='itemTitle']" should contain text "Case"




  @quoteTestCase1
  Scenario: Responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1280 and 1024
    Then element with xpath "//*[@id='location']/..//span" should be displayed
    Then element with xpath "//*[@id='currentDate']/..//span" should be displayed
    Then element with xpath "//*[@id='currentTime']/..//span" should be displayed
    And I resize window to 1000 and 1024
    Then element with xpath "//*[@id='location']/..//span" should be displayed
    Then element with xpath "//*[@id='currentDate']/..//span" should be displayed
    Then element with xpath "//*[@id='currentTime']/..//span" should be displayed
    And I resize window to 400 and 1024
    Then element with xpath "//*[@id='location']/..//span" should not be displayed
    Then element with xpath "//*[@id='currentDate']/..//span" should not be displayed
    Then element with xpath "//*[@id='currentTime']/..//span" should not be displayed


  @quoteTestCase2
  Scenario: Fill out and validate “Username” field.
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "m" into element with xpath "//*[@name='username'][@ng-model='formData.username']"
    When I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should contain text "Please enter at least 2 characters."
    When I clear element with xpath "//*[@name='username'][@ng-model='formData.username']"
    And I type "ma" into element with xpath "//*[@name='username'][@ng-model='formData.username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed



  @quoteTestCase3
  Scenario: Validate “Email” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "maksseli" into element with xpath "//*[@name='email'][@ng-model='formData.email']"
    When I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//*[@id='email-error']" should contain text "Please enter a valid email address."
    When I clear element with xpath "//*[@name='email'][@ng-model='formData.email']"
    And I type "maks@gmail.com" into element with xpath "//*[@name='email'][@ng-model='formData.email']"
    Then element with xpath "//*[@id='email-error']" should not be displayed


  @quoteTestCase4
  Scenario: Fill out and validate “Password” set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//*[@id='password']" should not have attribute "class" as "form-control ng-valid-maxlength ng-dirty ng-valid-parse error ng-touched ng-invalid ng-invalid-required"
    Then element with xpath "//*[@id='confirmPassword']" should have attribute "disabled" as "true"
    When I type "m" into element with xpath "//*[@id='password']"
    Then element with xpath "//*[@id='confirmPassword']" should not have attribute "disabled" as "disabled"
    Then I type "m" into element with xpath "//*[@id='confirmPassword']"

  @quoteTestCase5
  Scenario: “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
    And I type "Maks" into element with xpath "//*[@id='firstName']"
    And I type "Seli" into element with xpath "//*[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Maks Seli"

  @quoteTestCase6
  Scenario: Accepting Privacy Policy is required to submit the form
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "maks" into element with xpath "//input[@name='username']"
    And I type "maks@gmail.com" into element with xpath "//input[@name='email']"
    And I type "maksseli" into element with xpath "//input[@id='password']"
    And I type "maksseli" into element with xpath "//input[@id='confirmPassword']"
    And I type "Maks Seli" into element with xpath "//input[@id='name']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"


  @quoteTestCase7
  Scenario: entering the following non-required fields in the order
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "777-777-7777" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@*='USA']"
    And I click on element with xpath "//input[@ng-model='formData.gender'][@value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "1 main st, Chicago IL, 60092" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[@value='BMW']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@*='selectMonth']/option[3]"
    And I click on element with xpath "//select[@*='selectYear']/option[@*='1989']"
    And I click on element with xpath "//td[@*='selectDay']/a[text()='25']"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "03/25/1989"


  @quoteTestCase8
  Scenario: Submit the form and verify the data.
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "maks" into element with xpath "//input[@name='username']"
    And I type "maks@gmail.com" into element with xpath "//input[@name='email']"
    And I type "maksseli" into element with xpath "//input[@id='password']"
    And I type "maksseli" into element with xpath "//input[@id='confirmPassword']"
    And I type "Maks Seli" into element with xpath "//input[@id='name']"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should have text as "Submitted Application"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "maks"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "maks@gmail.com"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "Los Altos, CA 94022"
    Then element with xpath "//b[@name='currentDate']" should have text as "02/29/2020"
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    Then element with xpath "//b[@name='currentTime']" should contain text "Central Standard Time"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "Maks Seli"
    Then element with xpath "//b[@name='password']" should have text as "[entered]"

  @expediaTestCase9
  Scenario: Searching 5 stars hotels using Expedia
    Given I open url "https://www.expedia.com/"
    When I click on element with xpath "//button[@id='tab-hotel-tab-hp']"
    And I type "Miami" into element with xpath "//input[@id='hotel-destination-hp-hotel']"
    And I wait for element with xpath "//a[@data-value='Miami, Florida']" to be clickable
    And I click on element with xpath "//a[@data-value='Miami, Florida']"
    And I click on element with xpath "//input[@id='hotel-checkin-hp-hotel']"
    And I wait for element with xpath "//button[@class='datepicker-cal-date'][contains(text(),'25')]" to be present
    And I click on element with xpath "//button[@class='datepicker-cal-date'][contains(text(),'25')]"
    And I click on element with xpath "//input[@id='hotel-checkout-hp-hotel']"
    And I wait for element with xpath "//button[@class='datepicker-cal-date'][contains(text(),'31')]" to be present
    And I click on element with xpath "//button[@class='datepicker-cal-date'][contains(text(),'31')]"
    And I click on element with xpath "//form[@id='gcw-hotel-form-hp-hotel']//button[contains(@class,'gcw-submit')]"
    And I wait for element with xpath "//span[@class='uitk-button-toggle-content'][contains(text(),'5')]" to be present
    And I click on element with xpath "//span[@class='uitk-button-toggle-content'][contains(text(),'5')]"
    And I wait for element with xpath "//div[@class='uitk-cell all-cell-3-4 all-x-gutter-six']" to be present
    Then element with xpath "//span[text()='Excellent']" should have text as "Excellent"



