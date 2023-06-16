package pageObjects;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class DepositPage {
	WebDriver driver = DriverFactory.getdriver();
	String depositpage = ConfigReader.getDepositPage();
	String path = ConfigReader.getexcelfilepath();
	String sheetName = ConfigReader.getDepositSheetName();
	ExcelReader excelReaderUtil = new ExcelReader();
	String sheetDeposit;
	Properties properties;
	String alertMsg;

	public DepositPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountno']")
	@CacheLookup
	WebElement txtAccountNO;
	@FindBy(xpath = "//input[@name='balance']")
	@CacheLookup
	WebElement txtAmount;
	@FindBy(xpath = "//input[@name='desc']")
	@CacheLookup
	WebElement textDescription;
	@FindBy(xpath = "//label[@id='message2']")
	@CacheLookup
	WebElement lblAccErrorMsg;
	@FindBy(xpath = "//label[@id='message15']")
	@CacheLookup
	WebElement lblAmountErrorMsg;
	@FindBy(xpath = "//label[@id='message17']")
	@CacheLookup
	WebElement lblDescErrorMsg;
	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;
	@FindBy(xpath = "//input[@type='reset']")
	@CacheLookup
	WebElement btnReset;

	public void readExcelData(Scenario scenario) throws Exception {
		excelReaderUtil.readSheet(path, "Deposit");
		System.out.println(scenario.getName());
		driver.get(depositpage);
		String accountNo = excelReaderUtil.getDataFromExcel(scenario.getName(), "AccoutnNo");
		String amount = excelReaderUtil.getDataFromExcel(scenario.getName(), "Amount");
		String description = excelReaderUtil.getDataFromExcel(scenario.getName(), "Description");
		System.out.println("Account no :" + accountNo);
		System.out.println("Amount :" + amount);
		System.out.println("Description :" + description);
		txtAccountNO.sendKeys(accountNo);
		txtAmount.sendKeys(amount);
		textDescription.sendKeys(description);
	}

	public void enterDepositData(String accountNo, String amount, String description) {

		driver.get(depositpage);
		txtAccountNO.sendKeys(accountNo);
		txtAmount.sendKeys(amount);
		textDescription.sendKeys(description);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickSubmitButton() throws InterruptedException {
		Thread.sleep(3000);
		btnSubmit.click();
	}

	public void clickAlert() throws InterruptedException {
		// driver.navigate().refresh();
		Thread.sleep(3000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
				System.out.println("alert was not present");
			} else {
				System.out.println("alert was present");
				alertMsg = driver.switchTo().alert().getText();
				System.out.println("Alert messeage" + alertMsg);
				driver.switchTo().alert().accept();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void checkAlertMsg(String expectedMsg) {
		// assert.assertEquals(expectedMsg, expectedMsg, expectedMsg);
		assertEquals(expectedMsg, alertMsg);
	}

	public void checkLblMsgDescripiton(String expectedMsg) {
		assertEquals(expectedMsg, lblDescErrorMsg.getText());
	}

	public void checkLblMsgAmount(String expectedMsg) {
		assertEquals(expectedMsg, lblAccErrorMsg.getText());
	}

	public void checkLblMsgAccountNo(String expectedMsg) {
		assertEquals(expectedMsg, lblAccErrorMsg.getText());
	}
}
