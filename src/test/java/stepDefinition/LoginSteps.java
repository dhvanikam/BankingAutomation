package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pageObjects.LoginPageFactory;
import utilities.ConfigReader;

public class LoginSteps {
	
	WebDriver driver = DriverFactory.getdriver(); 
	LoginPageFactory loginPage = new LoginPageFactory(driver);	
	String loginPageurl = ConfigReader.getApplicationUrl();
	Logger logger = LogManager.getLogger();
	
	@Given("User navigates to the login page of the bank application")
	public void user_navigates_to_the_login_page_of_the_bank_application() {
		driver.get(loginPageurl);	
	}

	@When("User enter valid {string} in the UserID field")
	public void user_enter_valid_in_the_user_id_field(String Username) {
            loginPage.enterUserID(Username);
	}

	@When("Enter valid {string} in the Password field")
	public void enter_valid_in_the_password_field(String Password) {
           loginPage.enterPasswd(Password);
	}

	@When("Click Login button")
	public void click_login_button() {
	      loginPage.loginBtnclick();
	}

	@Then("User gets logged in to the application successfully")
	public void user_gets_logged_in_to_the_application_successfully() {
           logger.info("User is logged in");
	}

	@When("User enter below invalid details")
	public void user_enter_below_invalid_details(DataTable dataTable) {
       List<List<String>> datatableCred = dataTable.asLists(String.class);

       
	}

	@Then("Error message alert is displayed")
	public void error_message_alert_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User stays on the Login page after closing the error alert")
	public void user_stays_on_the_login_page_after_closing_the_error_alert() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enter valid mngr502686 in the User ID field")
	public void user_enter_valid_mngr502686_in_the_user_id_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Leave Password field blank")
	public void leave_password_field_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Error message is displayed")
	public void error_message_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enter valid pArUhud in the Password field")
	public void user_enter_valid_p_ar_uhud_in_the_password_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Leave UserID field blank")
	public void leave_user_id_field_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User leaves the UserID field blank")
	public void user_leaves_the_user_id_field_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Leaves Password field blank")
	public void leaves_password_field_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Error message is displayed for both the fields")
	public void error_message_is_displayed_for_both_the_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Leaves the UserID and Password fields blank")
	public void leaves_the_user_id_and_password_fields_blank() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User is navigated back to Login page after clicking Ok on error alert")
	public void user_is_navigated_back_to_login_page_after_clicking_ok_on_error_alert() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("User enter valid <Username> in the UserID field")
	public void user_enter_valid_username_in_the_user_id_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Enters valid <Password> in the Password field")
	public void enters_valid_password_in_the_password_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Clicks Reset button")
	public void clicks_reset_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Details present in UserID and Password field gets cleared")
	public void details_present_in_user_id_and_password_field_gets_cleared() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
