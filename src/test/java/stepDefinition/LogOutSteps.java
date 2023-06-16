package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pageObjects.LogoutPageFactory;
import pageObjects.LoginPageFactory;
import utilities.ConfigReader;

public class LogOutSteps {
	
	WebDriver driver = DriverFactory.getdriver();
	LogoutPageFactory logoutPage = new LogoutPageFactory(driver);
	String loginPageURL = ConfigReader.getApplicationUrl();
	LoginPageFactory loginPagefactory = new LoginPageFactory(driver);
	Logger logger = LogManager.getLogger();
	
	@When("User clicks Logout button from the home page of the application")
	public void user_clicks_logout_button_from_the_home_page_of_the_application() {
		logoutPage.clickLogout();
	}

	@Then("Successfuly logout alert message is displayed")
	public void successfuly_logout_alert_message_is_displayed() {
     String alertText = driver.switchTo().alert().getText();
     System.out.println("This is the alert text after Logout " +alertText);
     Assert.assertEquals(alertText, "You Have Succesfully Logged Out!!"); 
	}

	@Then("User is navigated to the Login page after clicking Ok from the alert message")
	public void user_is_navigated_to_the_login_page_after_clicking_ok_from_the_alert_message() {
     driver.switchTo().alert().accept();
     String actualURL = driver.getCurrentUrl();
     System.out.println("This is the URL after accepting logout alert " +actualURL);
     //Assert.assertEquals(actualURL, loginPageURL);
    String heading = loginPagefactory.getHeading();
     System.out.println("This is login page heading: " +heading);
     Assert.assertEquals(heading, "Guru99 Bank");
	}
}
