package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test(priority=0)
	public void TestValidLogin() {
		Log.info("Starting Login Test......!!!!!");
		test =ExtentReportManager.createTest("LoginTest");
             
		test.info("Navigating to the URL");
		LoginPage LoginPage = new LoginPage(driver);
		
		
		Log.info("Adding the Credentials!!!!!");
		LoginPage.enterusername("admin@yourstore.com");
		LoginPage.enterpassword("admin");
		LoginPage.clickloginbutton();
		test.info("Entered Credentials and clicked Login");
		
		Log.info("Verifying the Page Title......!!!!!!");
		System.out.println("Title of the Page is:" + driver.getTitle());
		test.info("Verifying the page Title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		test.pass("Login successfull");

	}
	@Test(priority=1)
	public void TestLoginWithInvalidCredentials() {
		Log.info("Starting Login Test......!!!!!");
		test =ExtentReportManager.createTest("LoginTest with Invalid Credentials");
             
		test.info("Navigating to the URL");
		LoginPage LoginPage = new LoginPage(driver);
		
		
		Log.info("Adding the Credentials!!!!!");
		LoginPage.enterusername("admin1234@yourstore.com");
		LoginPage.enterpassword("admin");
		LoginPage.clickloginbutton();
		test.info("Entered Credentials and clicked Login");
		
		Log.info("Verifying the Page Title......!!!!!!");
		System.out.println("Title of the Page is:" + driver.getTitle());
		test.info("Verifying the page Title");
		Assert.assertEquals(driver.getTitle(), "Just a moment...7888");
		test.pass("Login successfull");

	}
}
