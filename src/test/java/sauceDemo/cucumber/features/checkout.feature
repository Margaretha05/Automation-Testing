Feature: Checkout

  Background: User is Logged In and In dashboard page
    Given Login Page Swab Lags
    When input username
    And input password
    And click login button
    Then user in on dashboard page

  Scenario: Add Product to cart
    Given user in on dashboard page
    And user click button Add to Chart
    Then the product will be add to cart
    And Button Add to cart will be change to button Remove

  @Positive
  Scenario: User create checkout information using first name, last name and valid zip code
    Given user click cart
    When user click button Checkout
    And user input First Name valid
    And user input Last Name valid
    And user input Zipcode Code valid
    And user click button Continue
    And user click Finish button
    Then user can create checkout information and the application displays the Checkout: Complete! page

  @Negative
  Scenario: User create checkout information using first name, last name and invalid zip code
  Given user click cart
    When user click button Checkout
    And user input First Name valid
    And user input Last Name valid
    And user input Zipcode empty
    And user click button Continue
    Then user cannot proceed to page Checkout: Overview page and cannot continue the checkout process