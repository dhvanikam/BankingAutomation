package appHooks;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Label;
import utilities.ConfigReader;
import utilities.Loggerload;

public class Hooks {
	private static WebDriver driver;
	private static DriverFactory driverfactory;
	static Scenario scenario;

	@Before(order=0)
	public static void before() throws Throwable {
		//Get browser Type from config file
		Loggerload.info("Loading Config file");
		
		ConfigReader.loadConfig();
//		String browser = ConfigReader.getBrowserType();
		String browser = System.getProperty("browser");
		//Initialize driver from driver factory
		driverfactory = new DriverFactory();
		Loggerload.info("Initializing driver for : "+browser);
		driver = driverfactory.initializeDrivers(browser);
		
	
	}

	@Before(order=1)
	public void scenario(Scenario scenario) {
		Loggerload.info("===============================================================================================");
		Loggerload.info(scenario.getSourceTagNames() +" : "+scenario.getName());
		Loggerload.info("-----------------------------------------------------------------------------------------------");
		
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = capabilities.getBrowserName();
        String browserVersion = capabilities.getBrowserVersion();
        Platform operatingSystem = capabilities.getPlatformName();
        
		io.qameta.allure.Allure.addAttachment("Browser Name", browserName);
        io.qameta.allure.Allure.addAttachment("Browser Version", browserVersion);
        
        scenario.attach(browserName, "text/plain", "Browser Name: ");
        scenario.attach(browserVersion, "text/plain","Browser Version: ");
        
        
        Allure.getLifecycle().updateTestCase(testResult -> {
            testResult.getLabels().add(new Label().setName("Browser Name").setValue(browserName));
            testResult.getLabels().add(new Label().setName("Browser Version").setValue(browserVersion));
            testResult.getLabels().add(new Label().setName("Operating System").setValue(operatingSystem.toString()));
            
        });
        
        String currentdir = System.getProperty("user.dir");
        Loggerload.info(currentdir);
	}
	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			Loggerload.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		
		}
	}

	@After
	public static void after() {
		Loggerload.info("Closing Driver");
		driverfactory.closeallDriver();
	}
}
