package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BasePackage.SeleniumBase;
import Utilities.LoggerLoad;

public class LoginPage extends SeleniumBase {

	@FindBy(name = "username")
	WebElement eleusername;

	@FindBy(xpath = "//input[@name='password']")
	WebElement elepassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement eleloginBtn;

	public LoginPage launchUrl() throws Throwable {
		getUrl("url");
		return this;

	}
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage enterUsername() {
		
		if (eleusername != null) {
			eleusername.click();
			sendKeys(eleusername, "Admin");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		} else {
			LoggerLoad.info("Username is incorrect");
			Assert.fail("Incorrect username..please try with correct username");
		}
		return this;
	}

	public LoginPage enterPassword() {
		PageFactory.initElements(driver, this);
		if (elepassword != null) {
			sendKeys(elepassword, "admin123");
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		} else {
			LoggerLoad.info("Password is incorrect");
			Assert.fail("Incorrect password..please try with correct password");
		}
		return this;
	}

	public void clickLoginBtn() {
		PageFactory.initElements(driver, this);
		eleloginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	}

}
