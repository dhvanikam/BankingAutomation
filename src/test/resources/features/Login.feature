@BDDSTORY-BANKAUTO-200
Feature: Login Functionality
  As a user I want to validate the Login functionality of the Bank application

  @BDDTEST-BANKAUTO-201
  Scenario Outline: Validate the Login functionality with valid data
    Scenario Outline: Validate the Login functionality with valid data

    Given User navigates to the login page of the bank application
    When User enter valid "<Username>" in the UserID field
    And Enter valid "<Password>" in the Password field
    And Click Login button
    Then User gets logged in to the application successfully

    Examples: 
      | Username   | Password |
      | mngr502686 | pArUhud  |

  @BDDTEST-BANKAUTO-202
  Scenario Outline: Validate the elements present on the Login Page
    Given User navigates to the login page of the bank application
    Then Below <elements> should be displayed correctly

    Examples: 
      | elements       |
      | Heading        |
      | UserID field   |
      | Password field |
      | Login Button   |
      | Reset Button   |

  @BDDTEST-BANKAUTO-203
  Scenario Outline: Validate the Login functionality with invalid data
    Given User navigates to the login page of the bank application
    When User enter invalid <Username> in the UserID field
    And Enter invalid <Password> in the Password field
    And Click Login button
    Then Error message alert is displayed
    And User stays on the Login page after closing the error alert

    Examples: 
      | Username    | Password |
      | invalidUser | abcd123  |

  @BDDTEST-BANKAUTO-204
  Scenario Outline: Validate the behavior with empty Password field
    Given User navigates to the login page of the bank application
    When User enter valid <Username> in the User ID field
    And Leave Password field blank
    Then Error message is displayed

    Examples: 
      | Username   |
      | mngr502686 |

  @BDDTEST-BANKAUTO-205
  Scenario Outline: Validate the behavior with empty UserID field
    Given User navigates to the login page of the bank application
    When User enter valid <Password> in the Password field
    And Leave UserID field blank
    Then Error message is displayed

    Examples: 
      | Password |
      | pArUhud  |

  @BDDTEST-BANKAUTO-214
  Scenario: Validate the behaviour with empty UserID and Password fields
    Given User navigates to the login page of the bank application
    When User leaves the UserID field blank
    And Leaves Password field blank
    Then Error message is displayed for both the fields

  @BDDTEST-BANKAUTO-216
  Scenario: Valid functionality of Login button without login credentials
    Given User navigates to the login page of the bank application
    And Leaves the UserID and Password fields blank
    When User clicks on the Login button
    Then Error message alert is displayed
    And User is navigated back to Login page after clicking Ok on error alert

  @BDDTEST-BANKAUTO-219
  Scenario: Valid the functionality of Reset button
    Given User navigates to the login page of the bank application
    When User enter valid <Username> in the UserID field
    And Enters valid <Password> in the Password field
    And Clicks Reset button
    Then Details present in UserID and Password field gets cleared
