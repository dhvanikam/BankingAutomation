package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import utilities.ConfigReader;

public class LogoutPageFactory {
	
	WebDriver driver = DriverFactory.getdriver();
	Actions actions = new Actions(driver);
	
	public LogoutPageFactory(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);	
	}
	
    @FindBy(linkText="Log out")
    @CacheLookup
    WebElement logOutBtn;
    
    
    public void clickLogout() {
    	logOutBtn.click();
    }
}
