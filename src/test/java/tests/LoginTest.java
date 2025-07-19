package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void TestValidLogin()
	{
		
		LoginPage LoginPage=new LoginPage(driver);
		LoginPage.enterusername("admin@yourstore.com");
		LoginPage.enterpassword("admin");
		LoginPage.clickloginbutton();
		
		System.out.println("Title of the Page is:" +driver.getTitle());
		Assert.assertEquals(driver.getTitle(),"Just a moment...");
		
		
	}
}
