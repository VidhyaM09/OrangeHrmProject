package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BasePackage.SeleniumBase;
import Utilities.LoggerLoad;

public class MyinfoPage extends SeleniumBase {
	@FindBy(xpath = "//span[text()='My Info']")
	WebElement eleMyinfo;

	@FindBy(xpath = "//a[text()='Contact Details']")
	WebElement elecontactdetails;

	@FindBy(xpath = "//a[text()='Emergency Contacts']")
	WebElement eleemergencycontact;

	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement eleAddBtn;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement eleName;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement eleRelationship;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[4]")
	WebElement eleHometel;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[5]")
	WebElement eleMobile;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[6]")
	WebElement eleWorktel;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[9]")
	WebElement elecontactinput;

	@FindBy(xpath = "//button[text()=' Save ']")
	WebElement elesaveBtn;
	
	@FindBy(xpath = "(//button[@class='oxd-icon-button oxd-table-cell-action-space'])[1]")
	WebElement eledelBtn;
	
	@FindBy(xpath = "(//div[@class='oxd-table-cell oxd-padding-cell'])[2]")
	WebElement validateName;
	
	@FindBy(xpath = "//button[text()=' Yes, Delete ']")
	WebElement delConfirmBtn;
	
	

	public void clickMyinfo() throws InterruptedException {
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
		eleMyinfo.click();

	}

	public void editContactDetails() throws InterruptedException {
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
		elecontactdetails.click();
		Thread.sleep(3000);
		elecontactinput.clear();
		Thread.sleep(3000);
		elecontactinput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		Thread.sleep(3000);
		elecontactinput.click();
		sendKeys(elecontactinput, "012345678");
		Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		elesaveBtn.click();
	}

	public void editEmergencyContactDetails() throws InterruptedException {
		PageFactory.initElements(driver, this);
		Thread.sleep(2000);
		eleemergencycontact.click();
		Thread.sleep(3000);
		eleAddBtn.click();
		Thread.sleep(2000);
		
		sendKeys(eleName, "John");
		Thread.sleep(3000);

		eleRelationship.click();
		sendKeys(eleRelationship, "Brother");
		Thread.sleep(3000);

	    eleHometel.click();
		sendKeys(eleHometel, "042259442");
		Thread.sleep(3000);

		eleMobile.click();
		sendKeys(eleMobile, "9842259442");
		Thread.sleep(3000);

//	    eleWorktel.click();
//		sendKeys(eleWorktel,"04223596570");
//		Thread.sleep(3000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
		elesaveBtn.click();
	}
	
//	public void validateEmergencyContact() throws InterruptedException {
//		String expected="John";
//		Thread.sleep(3000);
//		System.out.println(validateName.getText());
//		if(validateName.getText().equals(expected)) {
//			Thread.sleep(3000);
//			LoggerLoad.info("Name validation is done");
//			eledelBtn.click();
//			Thread.sleep(2000);
//			delConfirmBtn.click();
//		}
//	}
}
