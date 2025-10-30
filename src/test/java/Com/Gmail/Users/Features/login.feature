Feature: Store login
This feature deals with the login

  Background:
    Given I navigate to login page

  @TC1
  Scenario: Login with correct username and correct password
  # Given I navigate to login page
    And I entered username and password
    And I clicked signin button
    Then Its navigated to the HomePage

  @TC2
  Scenario: Login with correct username and invlid password
  # Given I navigate to login page
    And I entered correct username
    But Invalid pwd
    And I clicked signin button
    Then Its navigated to the error msg

  @datatable
  Scenario: Login with correct username and correct password using DataTable
    Given I navigate to login page
  # When I entered username and password
  # When I entered "admin1" and "pass1"
    When I entered following details
      | userName | passWord |
      | mercury  | mercury  |
      | mercury  | asdf     |
      | mercury  | mercury  |
    And I clicked signin button
    Then Its navigated to the HomePage

  Scenario Outline: Data driven testing using scenario outline
    Given I navigate to login page
  # And I entered username and password
    When I insert "<userName>" and "<passWord>"
    And I clicked signin button
    Then Its navigated to the HomePage "<expectedResult>"

    Examples:
      | userName | passWord | expectedResult |
      | mercury   | mercury  | pass |
      | admin2   | mercury  | fail |
      | mercury   | admin33  | fail |
