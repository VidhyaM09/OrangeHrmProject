package Pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.SeleniumBase;



public class LoginPage extends SeleniumBase {
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[1]")
	WebElement eleusername;
	
	@FindBy(name="//input[@name='password']")
	WebElement elepassword;
	
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public LoginPage launchUrl() throws Throwable {
		getUrl("url");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		return this;
		
	}
	
	public void login() {
	    if (eleusername != null) {
	        if (eleusername.isDisplayed()) {
	            System.out.println("Displayed");
	            eleusername.click();
	            sendKeys(eleusername, "Admin");
	        }
	    } else {
	        System.out.println("eleusername is null.");
	    }
	}

	
}
