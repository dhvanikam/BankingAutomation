package pageObjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import io.cucumber.java.Scenario;
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

	public DepositPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountno']")
	@CacheLookup
	WebElement txtAccountNO;
	@FindBy(xpath = "//label[@name='balance']")
	@CacheLookup
	WebElement txtAmount;
	@FindBy(xpath = "//input[@name='desc']")
	@CacheLookup
	WebElement textDescription;
	@FindBy(xpath = "//label[@id='message2']")
	@CacheLookup
	WebElement txtAccErrorMsg;
	@FindBy(xpath = "//label[@id='message15']")
	@CacheLookup
	WebElement txtAmountErrorMsg;
	@FindBy(xpath = "//label[@id='message17']")
	@CacheLookup
	WebElement txtDescErrorMsg;

	public void readExcelData(Scenario scenario) throws Exception {	
		excelReaderUtil.readSheet(path,"Deposit");
		System.out.println(scenario.getName());
		String accountNo = excelReaderUtil.getDataFromExcel(scenario.getName(), "AccoutnNo");
		String amount = excelReaderUtil.getDataFromExcel(scenario.getName(), "Amount");
		String description = excelReaderUtil.getDataFromExcel(scenario.getName(), "Description");
		System.out.println("Account no :" + accountNo);
		System.out.println("Amount :" + amount);
		System.out.println("Description :" + description);
	}
}
