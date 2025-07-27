package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;


public class LoginPage {

	private WebDriver driver;
	private WebDriverWait wait;
	/*private By UsernamenameTextbox = By.id("Email");

	private By PasswordTextBox = By.id("Password");

	private By LoginButton = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button");
*/
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@FindBy(id="Email")
	WebElement UsernameTextbox;
	
	@FindBy(id="Password")
	WebElement PasswordTextBox;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement LoginButton;

	public void enterusername(String username)
	{
		UsernameTextbox.clear();
		UsernameTextbox.sendKeys(username);
		//driver.findElement(UsernamenameTextbox).clear();
		//driver.findElement(UsernamenameTextbox).sendKeys(username);

	}

	public void enterpassword(String password) {
		
		PasswordTextBox.clear();
		PasswordTextBox.sendKeys(password);
		//driver.findElement(PasswordTextBox).clear();
		//driver.findElement(PasswordTextBox).sendKeys(password);

	}

	public void clickloginbutton() {
		Log.info("Clicking the Login Button....!!!!!!");
		//driver.findElement(LoginButton).click();
		LoginButton.click();
	
	}
}
