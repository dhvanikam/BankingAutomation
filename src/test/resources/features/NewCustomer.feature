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

  #@BDDTEST-BANKAUTO-240
  #Scenario: Verifying new customer functionality when calendar window is displayed and active when the calendar is invoked by pressing the calendar icon.
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
#
  #@BDDTEST-BANKAUTO-241
  #Scenario: Verifying that calendar should display the current month, and the current dates should be highlighted.
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user check the current date is highlighted for current month
    #Then Current date should be highlighted for current month
#
  #@BDDTEST-BANKAUTO-242
  #Scenario: Verify that the user should be able to enter a date in that date field by selecting from calendar
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user clicks on desire Year and Month and click on date
    #Then Selected Date should reflect in textbox and claender window should disapppear
#
  #@BDDTEST-BANKAUTO-243
  #Scenario: Verify that when a date is selected in the calendar (double click or some other method), the chosen date is displayed in the text box and calendar should be disappeared from there.
#
#
  #@BDDTEST-BANKAUTO-244
  #Scenario: Verify that by using the up and then the down button, and the user can switch from one month to another.
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user click on up button to switch to previous months
    #Then The user should be able to navigate to previous months
    #When The user click on up button to switch to previous months
    #Then The user should be able to navigate to next months
#
  #@BDDTEST-BANKAUTO-245
  #Scenario: Verify that by using the dropdown button, and the user can switch from one year to another.
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user click on drop down to switch to years
    #Then The user should be able to navigate to previous and next years
#
  #@BDDTEST-BANKAUTO-246
  #Scenario: Verify that whether a user can edit date in text box(mm-dd-yyyy)
    #Given The user is on new customer after sign in
    #When The user click on text box for "Date of Birth" field
    #Then The user mm (month) should be highlighted and editable
    #When The user enter month
    #Then Entered month should reflect in mm format and focus should move to dd and should be editable
    #When The user enter date
    #Then Entered date should reflect in dd format and focus should move to yyyy and should be editable should be editable
    #When The user enter year
    #Then Entered year should reflect in yyyy format
#
  #@BDDTEST-BANKAUTO-247
  #Scenario: Verify that whether a user can move and delete and edit month,date and year as format mm-dd-yyyy in date in text box
    #Given The user is on new customer after sign in
    #When The user click on text box for "Date of Birth" field
    #Then The user mm (month) should be highlighted and editable
    #When The user enter month date and year
    #Then Entered data should reflect
    #When The user can move cursor with left - right arrow
    #Then Cursor should move to and from mm dd yyyy
    #When The user delete month and enter new month
    #Then Month should be deleted and updated according to new value
#
  #@BDDTEST-BANKAUTO-248
  #Scenario: Verify that the date field should not accept the value for the day, less than one, and greater than 12.
    #Given The user is on new customer after sign in
    #When The user click on text box for "Date of Birth" field
    #Then The user mm (month) should be highlighted and editable
    #When The user enter invalid month
    #Then By default it should take last valid value that is 12 for month
#
  #@BDDTEST-BANKAUTO-249
  #Scenario: Verify that the date field should not accept the value for the day, less than one, and greater than 31.
    #Given The user is on new customer after sign in
    #When The user click on text box for "Date of Birth" field
    #Then The user mm (month) should be highlighted and editable
    #When The user enter invalid date
    #Then By default it should take last valid value that is 31 for month
#
  #@BDDTEST-BANKAUTO-250
  #Scenario: Verify Clear text link in Date of birth field
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user enter month date and year
    #Then Entered data should reflect
    #When The user clicks on "clear" text link
    #Then Entered Date should reset
#
  #@BDDTEST-BANKAUTO-251
  #Scenario: Verify Today text link in Date of Birth field
    #Given The user is on new customer after sign in
    #When The user click on calender icon for "Date of Birth" field
    #Then The user should presented with Calender window and it should be active
    #When The user enter month date and year
    #Then Entered data should reflect
    #When The user clicks on "Today" text link
    #Then Entered Date should change to Today's date according to system date
