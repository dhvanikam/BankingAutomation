@BDDSTORY-BANKAUTO-221
Feature: Logout functionality

  @BDDTEST-BANKAUTO-222
  Scenario Outline: Validate the functionality of Login button
    Given User navigates to the login page of the bank application
    And User enter valid "<Username>" in the UserID field
    And Enter valid "<Password>" in the Password field
    And User clicks on the Login button
    When User clicks Logout button from the home page of the application
    Then Successfuly logout alert message is displayed
    And User is navigated to the Login page after clicking Ok from the alert message

    Examples: 
      | Username   | Password |
      | mngr507972 | vubYbUt  |
      

