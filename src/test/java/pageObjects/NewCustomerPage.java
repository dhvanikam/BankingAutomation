package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactory.DriverFactory;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.ElementsUtils;
import utilities.ExcelReader;

public class NewCustomerPage {
	WebDriver driver = DriverFactory.getdriver();
	String newCustomerPage = ConfigReader.getnewCustomerPage();
	String path = ConfigReader.getexcelfilepath();
	String sheetName = ConfigReader.getCustomerSheetName();
	ExcelReader excelReaderUtil = new ExcelReader();
	ElementsUtils eleUtil = new ElementsUtils();
	String homepage = ConfigReader.getHomePage();

	// Locators
	@FindBy(xpath = "//input[@name='name']") WebElement txtCustomerName;
	@FindBy(xpath = "//input[@name='rad1']") WebElement radioGender;
	@FindBy(id = "dob") WebElement txtDOB;
	@FindBy(xpath = "//textarea[@name='addr']") WebElement txtAddress;
	@FindBy(xpath = "//input[@name='city']") WebElement txtCity;
	@FindBy(xpath = "//input[@name='state']") WebElement txtState;
	@FindBy(xpath = "//input[@name='pinno']") WebElement txtPinNum;
	@FindBy(xpath = "//input[@name='telephoneno']") WebElement txtTelephoneNum;
	@FindBy(xpath = "//input[@name='emailid']") WebElement txtEmailID;
	@FindBy(xpath = "//input[@name='password']") WebElement txtPassword;
	@FindBy(xpath = "//input[@name='sub']") WebElement btnSubmit;
	@FindBy(xpath = "//input[@name='res']") WebElement btnReset;
	@FindBy(id = "picker") WebElement picker;
	@FindBy(className = "heading3") WebElement successMsg;
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void checkAllFieldsAvailable() {
		System.out.println("Check elment present");

	}

	public void enterAllValue(Scenario scenario) throws Exception {
		excelReaderUtil.readSheet(path, sheetName);
		System.out.println(scenario.getName());
		driver.get(newCustomerPage);

		txtCustomerName.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "Customer Name"));
		radioGender.click();
		txtDOB.sendKeys("10");
		txtDOB.sendKeys("10");
		txtDOB.sendKeys("2023");
		
		txtAddress.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "Address"));
		txtCity.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "City"));
		txtState.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "State"));
		txtPinNum.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "PIN"));
		txtTelephoneNum.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "Mobile Number"));
		txtEmailID.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "E-mail"));
		txtPassword.sendKeys(excelReaderUtil.getDataFromExcel(scenario.getName(), "Password"));

	}

	public String getSuccessMessage() {
		return successMsg.getText();

	}

	public String getErrorMessage() {
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		alert.accept();
		return msg;

	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
