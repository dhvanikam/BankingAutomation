package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import utilities.ConfigReader;
import utilities.ElementsUtils;

public class NewCustomer {
	WebDriver driver = DriverFactory.getdriver();
	ElementsUtils eleUtil = new ElementsUtils();

	String homepage = ConfigReader.getHomePage();

	// Homepage Locators
	//a[contains(text(),"New Customer")]
	
	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}

}
