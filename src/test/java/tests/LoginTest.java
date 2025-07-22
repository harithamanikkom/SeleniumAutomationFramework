package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

	@Test
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
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		test.pass("Login successfull");

	}
}
