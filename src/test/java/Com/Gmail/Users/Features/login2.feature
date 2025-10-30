Feature: Store login
This feature deals with the login functionality.

  Scenario: Login with correct username and correct password
    Given I navigate to login page
  # And I entered username and password
    When I entered "admin1" and "pass1"
    And I clicked signin button
    Then Its navigated to the HomePage
