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
		String actualErrorMsg=customer.getSuccessMessage();
		Assert.assertEquals(actualErrorMsg, "Customer Registered Successfully!!!");
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

}