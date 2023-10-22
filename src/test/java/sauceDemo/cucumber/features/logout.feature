Feature: Logout Page Swab Lags

  Background: User is Logged In and In dashboard page
    Given Login Page Swab Lags
    When input username
    And input password
    And click login button
    Then user in on dashboard page

  Scenario: Logout Page Swab Lags
    Given user click sidebar menu
    When user click Logout button
    Then user back to login page