package pageObjects;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;
import io.cucumber.java.Scenario;
import io.netty.handler.timeout.TimeoutException;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class LoginPageFactory {
	
	WebDriver driver = DriverFactory.getdriver();
	String LoginPage = ConfigReader.getApplicationUrl();
	Actions actions = new Actions(driver);

	@FindBy(name="uid")
	@CacheLookup
	WebElement userID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement passwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement resetBtn;
	
	@FindBy(xpath = "//h2[text()='Guru99 Bank']")
    @CacheLookup
    WebElement pageHeading;
	
	@FindBy(id="message18")
	@CacheLookup
	WebElement blankPasswordMsg;
	
	@FindBy(id="message23")
	@CacheLookup
	WebElement blankUsernameMsg;
	
	public LoginPageFactory(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(d, this);
	    }
	
	public void enterUserID(String Username) {
		userID.sendKeys(Username);
	}
	
	public void enterPasswd(String Password) {
		userID.sendKeys(Password);
	}
	
	public void loginBtnclick() {
		loginBtn.click();
	}
	
	public void resetBtnClick() {
		resetBtn.click();
	}
	
	public String getHeading() {
		return pageHeading.getText();
	
	}
	
	public String getPswdErrorMsg() {
		return blankPasswordMsg.getText();
	
	}
	
	public String getUsrnameErrorMsg() {
		return blankUsernameMsg.getText();
	
	}
	
	public void clickPasswordField() {
		
		actions.contextClick(passwd);
		actions.sendKeys(Keys.TAB);
	}
	
	public void clickUserNameField() {
		
		actions.contextClick(userID);
		actions.sendKeys(Keys.TAB);
	}
	
}
