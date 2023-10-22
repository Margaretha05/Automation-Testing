Feature: Login Page Swab Lags

  @Positive
  Scenario: Success Login
    Given Login Page Swab Lags
    When input username
    And input password
    And click login button
    Then user in on dashboard page

  @Negative
  Scenario: Failed Login
    Given Login Page Swab Lags
    When input username
    And input invalid password
    And click login button
    Then user get error message

