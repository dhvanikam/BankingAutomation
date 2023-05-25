@BDDSTORY-BANKAUTO-206
Feature: Deposit
  Create a feature file for Deposit functionality

  Background: 
    The user is logged in to banking website

    Given The user is on banking website login page
    When The user enter valid "mngr502686" and "pArUhud"
    And The user click on login button
    Then The user redirected to homepage

  @BDDTEST-BANKAUTO-215
  Scenario: Checking with valid data
    Given User enter valid Accountnumber,Amount,Description
    When Click on submit button
    Then User should see "successful transfer" alert message

  @BDDTEST-BANKAUTO-217
  Scenario: Checking with  blank data
    Given User enter blank Accountnumber,Amount,Description
    When Click on submit button
    Then User should see "Please enter all the field" alert message

  @BDDTEST-BANKAUTO-218
  Scenario: Checking with characters in  Account no
    Given User enter characters in AccountNo field
    Then user should see "Characters are not allowed" message

  @BDDTEST-BANKAUTO-220
  Scenario: Checking with empty space in Account no
    Given User enter blank space in AccountNO field
    Then User should be presented "Account Number must not be blank" message

  @BDDTEST-BANKAUTO-223
  Scenario: Checking with negetive number in Account no
    Given User enter negetive number in AccountNO field
    Then User should be presented "Negative numbers not allowed" message

  @BDDTEST-BANKAUTO-224
  Scenario: Checking with more than 10 digits in Account no
    Given User enter more than 10 digits in AccountNO field
    Then User should be blocked from entering any data

  @BDDTEST-BANKAUTO-225
  Scenario: Checking with space in between Account No
    Given User enter space in between AcoountNo field
    Then User should be presented "Characters are not allowed" message

  @BDDTEST-BANKAUTO-226
  Scenario: Checking with special character in Account No
    Given User enter special Charater in AccountNO Field
    Then User should be presented "Special characters are not allowed" message
