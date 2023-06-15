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
	String loginPageLanding = ConfigReader.getLoginPage();
	Actions actions = new Actions(driver);
	String path = ConfigReader.getexcelfilepath();
	String sheetName = ConfigReader.getDepositSheetName();
	ExcelReader excelReaderUtil = new ExcelReader();
	
	
	@FindBy(xpath="//input[@onkeyup='validateuserid();']")
	@CacheLookup
	WebElement userID;
	
	@FindBy(xpath="//input[@onkeyup='validatepassword();']")
	@CacheLookup
	WebElement passwd;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(name="btnReset")
	@CacheLookup
	WebElement resetBtn;
	
	//@FindBy(xpath = "//h2[text()='Guru99 Bank']")
	@FindBy(xpath="//h2[@class='barone']")
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
	
	public void readExcelData(Scenario scenario) throws Exception {
		excelReaderUtil.readSheet(path, "Login");
		System.out.println("This is scenario name from Excel sheet" +scenario.getName());
		driver.get(loginPageLanding);
		String excelUserID = excelReaderUtil.getDataFromExcel(scenario.getName(), "UserID");
		String excelPassword = excelReaderUtil.getDataFromExcel(scenario.getName(), "Password");
		System.out.println("UserID :"  +excelUserID);
		System.out.println("Password :" +excelPassword);
		userID.sendKeys(excelUserID);
		passwd.sendKeys(excelPassword);
	}
	
	public void enterUserID(String Username) {
		userID.sendKeys(Username,Keys.TAB);
	}
	
	public void enterPasswd(String Password) {
		passwd.sendKeys(Password, Keys.TAB);
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
         passwd.click();
		//actions.contextClick(passwd);
		actions.sendKeys(passwd, Keys.TAB).perform();
	}
	
	public void clickUserNameField() {
		userID.click();
		//actions.contextClick(userID);
		actions.sendKeys(userID, Keys.TAB).perform();
	}
	
	public String emptyUserId() {

		return userID.getText();
	}
	
	public String emptyPassword() {
		return passwd.getText();
	}
}
