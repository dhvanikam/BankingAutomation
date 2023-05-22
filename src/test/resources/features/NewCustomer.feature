@BDDSTORY-BANKAUTO-195 @Customer
Feature: NewCustomer
  Test New Customer Module Functionality

  Background: 
    The user is logged in to banking website

    Given The user is on banking website login page
    When The user enter valid "mngr502686" and "pArUhud"
    And The user click on login button
    Then The user redirected to homepage

  @BDDTEST-BANKAUTO-196 @sanity
  Scenario Outline: Verifying new customer functionality when user enters all valid details and submit
    Given The user is on homepage after sign in
    When The user clicks on new customer link
    Then The user presented with all fields for new customer
    When The user enters valid "<Customer Name>", "Gender", "Date of Birth","<Address>", "<City>", "<State>","<PIN>","<Mobile Number>","<E-mail>","<Password>" and click on submit
    Then The user presented with success message

    Examples: 
      | Customer Name | Address     | City     | State    | PIN   | Mobile Number | E-mail         | Password |
      | John          | TestAddress | TestCity | Teststat | 12345 |      12345678 | john@gmail.com | testtest |

  @BDDTEST-BANKAUTO-197
  Scenario Outline: Verifying new customer functionality when user enters invalid Customer Name
    Given The user is on homepage after sign in
    When The user clicks on new customer link
    Then The user presented with all fields for new customer
    When The user enters invalid "<Customer Name>"
    Then The user should presented with "<Error Message">

    Examples: 
      | Customer Name | Error Message                   |
      |               | Customer name must not be blank |
      |         12345 | Numbers are not allowed         |
