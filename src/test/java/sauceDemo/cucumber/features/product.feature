Feature: Add Product to cart

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
