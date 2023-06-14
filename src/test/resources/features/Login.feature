@BDDSTORY-BANKAUTO-200
Feature: Login Functionality
  As a user I want to validate the Login functionality of the Bank application

  @BDDTEST-BANKAUTO-203
  Scenario: Validate the Login functionality with invalid data using datatable
  	Given User navigates to the login page of the bank application
    When User enter below invalid details
      | invUser | abcd123 |
    And User clicks on the Login button
    Then Error message alert is displayed
    And User stays on the Login page after closing the error alert
    
  @BDDTEST-BANKAUTO-255
  Scenario: Validate the login with invalid data using excel sheet
  	Given User navigates to the login page of the bank application
    When User enter below invalid UserID and Password details mentioned in excel sheet
    And User clicks on the Login button
    Then Error message alert is displayed
    And User stays on the Login page after closing the error alert

  @BDDTEST-BANKAUTO-204
  Scenario Outline: Validate the behavior with empty Password field
    Given User navigates to the login page of the bank application
    When User enter valid "<Username>" in the UserID field
    And Leave Password field blank
    Then Error message for Password field is displayed

    Examples: 
      | Username   |
      | mngr507972 |

  @BDDTEST-BANKAUTO-205
  Scenario Outline: Validate the behavior with empty UserID field
    Given User navigates to the login page of the bank application
    When Enter valid "<Password>" in the Password field
    And Leave UserID field blank
    Then Error message for UserID field is displayed

    Examples: 
      | Password |
      | vubYbUt  |

  @BDDTEST-BANKAUTO-214
  Scenario: Validate the behaviour with empty UserID and Password fields
    Given User navigates to the login page of the bank application
    When Leave UserID field blank
    And  Leave UserID field blank
    Then Error message for UserID field is displayed
    And  Error message for Password field is displayed

  @BDDTEST-BANKAUTO-216
  Scenario: Valid functionality of Login button without login credentials
    Given User navigates to the login page of the bank application
    And Leaves the UserID and Password fields blank
    When User clicks on the Login button
    Then Error message alert is displayed
    And User is navigated back to Login page after clicking Ok on error alert

  @BDDTEST-BANKAUTO-219
  Scenario Outline: Valid the functionality of Reset button
    Given User navigates to the login page of the bank application
    When User enter valid "<Username>" in the UserID field
    And Enter valid "<Password>" in the Password field
    And Clicks Reset button
    Then Details present in UserID and Password field gets cleared
     
        Examples: 
      | Username   | Password |
      | mngr507972 | vubYbUt  |
      
    
  @BDDTEST-BANKAUTO-201
  Scenario Outline: Validate the Login functionality with valid data
    Given User navigates to the login page of the bank application
    When User enter valid "<Username>" in the UserID field
    And Enter valid "<Password>" in the Password field
    And User clicks on the Login button
    Then User gets logged in to the application successfully

    Examples: 
      | Username   | Password |
      | mngr507972 | vubYbUt  |
