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
    When Click on Submit button
    Then User should see "Please enter all the field" alert message

  @BDDTEST-BANKAUTO-218
  Scenario: Checking with characters in  Account no
    Given User enter characters in AccountNo field
    Then user should see "Characters are not allowed" message
