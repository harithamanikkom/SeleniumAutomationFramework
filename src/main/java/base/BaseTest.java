package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.EmailUtils;
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
		String reportPath = ExtentReportManager.reportPath;
		System.out.println("Report Path is :" +reportPath);
		EmailUtils.sendTestReport(reportPath);

	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		Log.info("Starting the WebDriver......!!!");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Navigating to the URL!!!!!!");
		driver.get("https://admin-demo.nopcommerce.com/login");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		{
			if (result.getStatus() == ITestResult.FAILURE) {
				String ScreenshotPath = ExtentReportManager.captureScreenshot(driver, "Login Failure");

				test.fail("Test failed .Check screenshot",
						MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotPath).build());
			}
			if (driver != null) {
				Log.info("Closing the Browser!!!!!!");
				driver.quit();
			}
		}

	}
}
