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
import utilities.ConfigReader;
import utilities.ElementsUtils;
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
	ElementsUtils eleUtil = new ElementsUtils();

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
		try {
		excelReaderUtil.readSheet(path, "Deposit");
		System.out.println(scenario.getName());
		driver.get(depositpage);
		String accountNo = excelReaderUtil.getDataFromExcel(scenario.getName(), "AccoutnNo");
		String amount = excelReaderUtil.getDataFromExcel(scenario.getName(), "Amount");
		String description = excelReaderUtil.getDataFromExcel(scenario.getName(), "Description");
		eleUtil.waitForElement(txtAccountNO);
		txtAccountNO.sendKeys(accountNo);
		
		eleUtil.waitForElement(txtAmount);
		txtAmount.sendKeys(amount);
		
		eleUtil.waitForElement(textDescription);
		textDescription.sendKeys(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterDepositData(String accountNo, String amount, String description) {
		try {
		driver.get(depositpage);
		
		txtAccountNO.sendKeys(accountNo);
		txtAmount.sendKeys(amount);
		textDescription.sendKeys(description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickSubmitButton() throws InterruptedException {
		try {
		//Thread.sleep(1000);
			
		btnSubmit.click();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

	public void clickAlert() throws InterruptedException {
		// driver.navigate().refresh();
		//Thread.sleep(1000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
