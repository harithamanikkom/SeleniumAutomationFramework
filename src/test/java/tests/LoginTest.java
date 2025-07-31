package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {

//	//@DataProvider(name = "LoginData")
//	//public Object[][] getLoginData() throws IOException {
//		//String filePath = System.getProperty("user.dir") + "/Testdata/TestData.xlsx";
//		ExcelUtils.loadExcel(filePath, "Sheet1");
//		int rowCount = ExcelUtils.getRowCount();
//		Object[][] data = new Object[rowCount - 1][2];
//		for (int i = 1; i < rowCount; i++) {
//			data[i - 1][0] = ExcelUtils.getCellData(i, 0);// username
//			data[i - 1][1] = ExcelUtils.getCellData(i, 1);// password
//		}
//		ExcelUtils.closeExcel();
//		return data;
//	}
//
	
@DataProvider(name = "LoginData2")
public Object[][] getData() {
	return new Object[][] { 
		{ "user1", "pass1" }, 
		{ "user2", "pass2" }, 
		{ "user3", "pass3" } 
			};
}
//
//	// @Test(dataProvider = "LoginData2")
//	@Test
//	@Parameters({ "username", "password" })
//	public void TestValidLogin(String username, String password) {
	@Test
	public void TestValidLogin() throws InterruptedException {
		Log.info("Starting Login Test......!!!!!");
		//test = ExtentReportManager.createTest("LoginTest: " + username);
		test = ExtentReportManager.createTest("LoginTest: ");
		test.info("Navigating to the URL");
		LoginPage LoginPage = new LoginPage(driver);

		 LoginPage.enterusername("admin@yourstore.com");
		 LoginPage.enterpassword("admin");

		Log.info("Adding the Credentials!!!!!");
		//LoginPage.enterusername(username);
		//LoginPage.enterpassword(password);
		LoginPage.clickloginbutton();
		test.info("Entered Credentials and clicked Login");

		Log.info("Verifying the Page Title......!!!!!!");
		System.out.println("Title of the Page is:" + driver.getTitle());
		test.info("Verifying the page Title");
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration......ABCD");
		test.pass("Login successfull");

	}

//	@Test(dataProvider = "LoginData")
//	public void TestLoginWithInvalidCredentials(String username, String password) {
//		Log.info("Starting Login Test......!!!!!");
//		test = ExtentReportManager.createTest("LoginTest with Invalid Credentials");
//
//		test.info("Navigating to the URL");
//		LoginPage LoginPage = new LoginPage(driver);
//
//		Log.info("Adding the Credentials!!!!!");
//		// LoginPage.enterusername("admin1234@yourstore.com");
//		// LoginPage.enterpassword("admin");
//
//		LoginPage.enterusername(username);
//		LoginPage.enterpassword(password);
//		LoginPage.clickloginbutton();
//		test.info("Entered Credentials and clicked Login");
//
//		Log.info("Verifying the Page Title......!!!!!!");
//		System.out.println("Title of the Page is:" + driver.getTitle());
//		test.info("Verifying the page Title");
//		Assert.assertEquals(driver.getTitle(), "Just a moment...7888");
//		test.pass("Login successfull");
//
}
