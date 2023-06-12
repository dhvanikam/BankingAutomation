package stepDefinition;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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

	@When("Click on Login button")
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
		for (List<String> stringData : datatableCred) {
			String invalidUserName = stringData.get(0);
			loginPage.enterUserID(invalidUserName);
			String invalidPassword = stringData.get(1);
			loginPage.enterPasswd(invalidPassword);
    	}
	}

	@Then("Error message alert is displayed")
	public void error_message_alert_is_displayed() {
		String actualalert = driver.switchTo().alert().getText();
		Assert.assertEquals(actualalert, "User or Password is not valid");
		driver.switchTo().alert().accept();
	}

	@Then("User stays on the Login page after closing the error alert")
	public void user_stays_on_the_login_page_after_closing_the_error_alert() {
		String actualHeading = loginPage.getHeading();
		Assert.assertEquals(actualHeading, "Guru99 Bank");
	}

	@When("Leave Password field blank")
	public void leave_password_field_blank() {
        logger.info("Password field is left blank");
        loginPage.clickPasswordField();
	}

	@Then("Error message for Password field is displayed")
	public void error_message_for_Password_field_is_displayed() {
		String actualErrMsg = loginPage.getPswdErrorMsg();
		System.out.println("This is error message from the alert: " +actualErrMsg);
		Assert.assertEquals(actualErrMsg, "Password must not be blank");
	}

	@When("Leave UserID field blank")
	public void leave_user_id_field_blank() {
      logger.info("UserID field is left blank");
      loginPage.clickUserNameField();
	}

	@Then("Error message for UserID field is displayed")
	public void error_message_for_UserID_field_is_displayed() {
		String actualErrMsg = loginPage.getUsrnameErrorMsg();
		System.out.println("This is error message from the alert: " +actualErrMsg);
		Assert.assertEquals(actualErrMsg, "User-ID must not be blank");
		
	}
	
	@Then("Error message is displayed for both the fields")
	public void error_message_is_displayed_for_both_the_fields() {
		String actualErrMsgUId = loginPage.getUsrnameErrorMsg();
		Assert.assertEquals(actualErrMsgUId, "User-ID must not be blank");
		System.out.println("This is error message from the alert: " +actualErrMsgUId);
		String actualErrMsgPwd = loginPage.getPswdErrorMsg();
		System.out.println("This is error message from the alert: " +actualErrMsgPwd);
		Assert.assertEquals(actualErrMsgPwd, "Password must not be blank");
		
	}

	@Given("Leaves the UserID and Password fields blank")
	public void leaves_the_user_id_and_password_fields_blank() {
       logger.info("UserID and Password fields are left blank");
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
      loginPage.loginBtnclick();
	}

	@Then("User is navigated back to Login page after clicking Ok on error alert")
	public void user_is_navigated_back_to_login_page_after_clicking_ok_on_error_alert() {
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, "https://demo.guru99.com/V4/index.php");
	}

	@When("Clicks Reset button")
	public void clicks_reset_button() {
     loginPage.resetBtnClick();
	}

	@Then("Details present in UserID and Password field gets cleared")
	public void details_present_in_user_id_and_password_field_gets_cleared() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
