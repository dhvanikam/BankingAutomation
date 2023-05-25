package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DepositPage;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class DepositSteps {
	DepositPage dp = new DepositPage();
	String path;
	String sheetDeposit;
	ExcelReader excelReaderUtil;
	Scenario scenario;
	Properties properties;

	public DepositSteps() {
		ConfigReader config = new ConfigReader();
		properties = config.loadProperties();
	}

	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
	}

	@Before
	public void initializeDataTable(Scenario scenario) throws Exception {
		this.scenario = scenario;
	}

	@Given("User enter valid Accountnumber,Amount,Description")
	public void user_enter_valid_accountnumber_amount_description() throws Exception {
		dp.readExcelData(scenario);
		System.out.println("valid data verfication");

	}

	@When("Click on submit button")
	public void click_on_submit_button() {
		System.out.println("click on submit button");
	}

	@Then("User should see {string} alert message")
	public void user_should_see_alert_message(String string) {
		System.out.println("Assert the valid data");
	}

	@Given("User enter blank Accountnumber,Amount,Description")
	public void user_enter_blank_accountnumber_amount_description() throws Exception {
		dp.readExcelData(scenario);
		System.out.println("test");
	}

	@Given("User enter characters in AccountNo field")
	public void user_enter_characters_in_account_no_field() {
		System.out.println("test");
	}

	@Then("user should see {string} message")
	public void user_should_see_message(String string) {
		System.out.println("test");
	}

	@Given("User enter blank space in AccountNO field")
	public void user_enter_blank_space_in_account_no_field() throws Exception {
		dp.readExcelData(scenario);
		System.out.println("test");
	}

	@Then("User should be presented {string} message")
	public void user_should_be_presented_message(String string) {
		System.out.println("test");
	}

	@Given("User enter negetive number in AccountNO field")
	public void user_enter_negetive_number_in_account_no_field() {
		System.out.println("test");
	}

	@Given("User enter more than {int} digits in AccountNO field")
	public void user_enter_more_than_digits_in_account_no_field(Integer int1) throws Exception {
		dp.readExcelData(scenario);
		System.out.println("test");
	}

	@Then("User should be blocked from entering any data")
	public void user_should_be_blocked_from_entering_any_data() {
		System.out.println("test");
	}

	@Given("User enter space in between AcoountNo field")
	public void user_enter_space_in_between_acoount_no_field() throws Exception {
		dp.readExcelData(scenario);
		System.out.println("test");
	}

	@Given("User enter special Charater in AccountNO Field")
	public void user_enter_special_charater_in_account_no_field() throws Exception {
		dp.readExcelData(scenario);
		System.out.println("test");
	}

}
