package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import utilities.ConfigReader;
import utilities.ElementsUtils;

public class HomePage {
	WebDriver driver = DriverFactory.getdriver();
	ElementsUtils eleUtil = new ElementsUtils();

	String homepage = ConfigReader.getHomePage();

	// Homepage Locators	
	@FindBy (xpath="//a[contains(text(),'New Customer')]")WebElement newCustomerLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToHomePage() {
		driver.get(homepage);
		
	}

	public void clickOnNewCustomerLink() {
		newCustomerLink.click();
		
	}

}
