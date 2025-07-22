package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {

	protected WebDriver driver;
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		Log.info("Starting the WebDriver......!!!");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to the URL!!!!!!");
		driver.get("https://admin-demo.nopcommerce.com/login");
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			Log.info("Closing the Browser!!!!!!");
			driver.quit();
		}
	}

}
