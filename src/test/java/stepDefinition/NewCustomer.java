package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class NewCustomer {
	HomePage homepage = new HomePage();

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
		System.out.println("All fields");
	}

	@When("The user enters valid {string}, {string}, {string},{string}, {string}, {string},{string},{string},{string},{string} and click on submit")
	public void the_user_enters_valid_and_click_on_submit(String string, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9, String string10) {
		System.out.println("Enter All fields");
	}

	@Then("The user presented with success message")
	public void the_user_presented_with_success_message() {
		System.out.println("validate message");
	}

	// @BDDTEST-BANKAUTO-197
	@When("The user enters invalid {string}")
	public void the_user_enters_invalid(String string) {
		System.out.println("Enter invalid fields");
	}

	@Then("The user should presented with {string}>")
	public void the_user_should_presented_with(String string) {
		System.out.println("validate error message");
	}
}
