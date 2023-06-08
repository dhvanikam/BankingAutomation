package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.NewCustomerPage;

public class NewCustomerSteps {
	Scenario scenario;
	HomePage homepage = new HomePage();
	NewCustomerPage customer = new NewCustomerPage();

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	// @BDDTEST-BANKAUTO-196
	@Given("The user is on homepage after sign in")
	public void the_user_is_on_homepage_after_sign_in() {
		homepage.navigateToHomePage();
	}

	@When("The user clicks on new customer link")
	public void the_user_clicks_on_new_customer_link() {
		homepage.clickOnNewCustomerLink();
	}

	@Then("The user presented with all fields for new customer")
	public void the_user_presented_with_all_fields_for_new_customer() {
		customer.checkAllFieldsAvailable();
	}

	@When("The user enters valid values for each fields and press submit button")
	public void the_user_enters_valid_values_for_each_fields_and_press_submit_button() throws Exception {
		customer.enterAllValue(scenario);
	}

	@Then("The user should be presented with success message")
	public void the_user_should_be_presented_with_success_message() {
		customer.getSuccessMessage();
	}

	// @BDDTEST-BANKAUTO-197
	@Given("The user is on new customer after sign in")
	public void the_user_is_on_new_customer_after_sign_in() {
		homepage.navigateToHomePage();
	}

	@When("The user do not enter {string} and press submit button")
	public void the_user_do_not_enter_and_press_submit_button(String string) throws Exception {
		customer.enterAllValue(scenario);
		customer.clickSubmit();
		
	}

	@Then("The user should presented with error message {string}")
	public void the_user_should_presented_with_error_message(String expectedErrorMsg) {
		String actualErrorMsg = customer.getErrorMessage();
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	// @BDDTEST-BANKAUTO-234
	@When("The user enter numeric values in {string} and press submit button")
	public void the_user_enter_numeric_values_in_and_press_submit_button(String string) throws Exception {
		customer.enterAllValue(scenario);
		customer.clickSubmit();
	}

	// @BDDTEST-BANKAUTO-238
	@When("The user enter special characters in {string} and press submit button")
	public void the_user_enter_special_characters_in_and_press_submit_button(String string) throws Exception {
		customer.enterAllValue(scenario);
		customer.clickSubmit();
	}

	// @BDDTEST-BANKAUTO-239
	@When("The user enter first character as space in {string} and press submit button")
	public void the_user_enter_first_character_as_space_in_and_press_submit_button(String string) throws Exception {
		customer.enterAllValue(scenario);
		customer.clickSubmit();
	}

	// @BDDTEST-BANKAUTO-240
	@When("The user click on calender icon for {string} field")
	public void the_user_click_on_calender_icon_for_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user should presented with Calender window and it should be active")
	public void the_user_should_presented_with_calender_window_and_it_should_be_active() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-240
	@When("The user check the current date is highlighted for current month")
	public void the_user_check_the_current_date_is_highlighted_for_current_month() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Current date should be highlighted for current month")
	public void current_date_should_be_highlighted_for_current_month() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-242
	@When("The user clicks on desire Year and Month and click on date")
	public void the_user_clicks_on_desire_year_and_month_and_click_on_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Selected Date should reflect in textbox and claender window should disapppear")
	public void selected_date_should_reflect_in_textbox_and_claender_window_should_disapppear() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-244
	@When("The user click on up button to switch to previous months")
	public void the_user_click_on_up_button_to_switch_to_previous_months() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be able to navigate to previous months")
	public void the_user_should_be_able_to_navigate_to_previous_months() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be able to navigate to next months")
	public void the_user_should_be_able_to_navigate_to_next_months() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-245
	@When("The user click on drop down to switch to years")
	public void the_user_click_on_drop_down_to_switch_to_years() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user should be able to navigate to previous and next years")
	public void the_user_should_be_able_to_navigate_to_previous_and_next_years() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-246
	@When("The user click on text box for {string} field")
	public void the_user_click_on_text_box_for_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("The user mm \\(month) should be highlighted and editable")
	public void the_user_mm_month_should_be_highlighted_and_editable() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user enter month")
	public void the_user_enter_month() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Entered month should reflect in mm format and focus should move to dd and should be editable")
	public void entered_month_should_reflect_in_mm_format_and_focus_should_move_to_dd_and_should_be_editable() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user enter date")
	public void the_user_enter_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Entered date should reflect in dd format and focus should move to yyyy and should be editable should be editable")
	public void entered_date_should_reflect_in_dd_format_and_focus_should_move_to_yyyy_and_should_be_editable_should_be_editable() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user enter year")
	public void the_user_enter_year() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Entered year should reflect in yyyy format")
	public void entered_year_should_reflect_in_yyyy_format() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-247
	@When("The user enter month date and year")
	public void the_user_enter_month_date_and_year() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Entered data should reflect")
	public void entered_data_should_reflect() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user can move cursor with left - right arrow")
	public void the_user_can_move_cursor_with_left_right_arrow() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Cursor should move to and from mm dd yyyy")
	public void cursor_should_move_to_and_from_mm_dd_yyyy() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("The user delete month and enter new month")
	public void the_user_delete_month_and_enter_new_month() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Month should be deleted and updated according to new value")
	public void month_should_be_deleted_and_updated_according_to_new_value() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-248
	@When("The user enter invalid month")
	public void the_user_enter_invalid_month() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("By default it should take last valid value that is {int} for month")
	public void by_default_it_should_take_last_valid_value_that_is_for_month(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-249
	@When("The user enter invalid date")
	public void the_user_enter_invalid_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-250
	@When("The user clicks on {string} text link")
	public void the_user_clicks_on_text_link(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Entered Date should reset")
	public void entered_date_should_reset() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// @BDDTEST-BANKAUTO-251
	@Then("Entered Date should change to Today's date according to system date")
	public void entered_date_should_change_to_today_s_date_according_to_system_date() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}