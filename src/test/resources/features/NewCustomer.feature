@BDDSTORY-BANKAUTO-195
@Customer
Feature: NewCustomer
  Test New Customer Module Functionality

  Background:
    The user is logged in to banking website
    Given The user is on banking website login page
    When The user enter valid "mngr502686" and "pArUhud"
    And The user click on login button
    Then The user redirected to homepage

  @BDDTEST-BANKAUTO-196
  @sanity
  Scenario: Verifying new customer functionality when user enters all valid details and submit
    Given The user is on homepage after sign in
    When The user clicks on new customer link
    Then The user presented with all fields for new customer
    When The user enters valid values for each fields and press submit button
    Then The user should be presented with success message

  @BDDTEST-BANKAUTO-197
  Scenario: Verifying new customer functionality when user do not enters Customer Name
    Given The user is on new customer after sign in
    When The user do not enter "Customer Name" and press submit button
    Then The user should presented with error message "please fill all fields"

  @BDDTEST-BANKAUTO-234
  Scenario: Verifying new customer functionality when user enters numeric values in Customer Name
    Given The user is on new customer after sign in
    When The user enter numeric values in "Customer Name" and press submit button
    Then The user should presented with error message "Numbers are not allowed"

  @BDDTEST-BANKAUTO-238
  Scenario: Verifying new customer functionality when user enters special characters in Customer Name
    Given The user is on new customer after sign in
    When The user enter special characters in "Customer Name" and press submit button
    Then The user should presented with error message "Special characters are not allowed"

  @BDDTEST-BANKAUTO-239
  Scenario: Verifying new customer functionality when user enters space as first character in Customer Name
    Given The user is on new customer after sign in
    When The user enter first character as space in "Customer Name" and press submit button
    Then The user should presented with error message "First character can not have space"
