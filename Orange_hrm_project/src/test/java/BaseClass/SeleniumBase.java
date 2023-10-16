package BaseClass;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utilities.ConfigFileReader;
import Utilities.LoggerLoad;

public class SeleniumBase {
	String base_url;
	public static WebDriver driver;
	String browserName;

	@BeforeTest
	public void beforeMethod() throws Throwable {
		browserName = ConfigFileReader.getValue("browserName");
		// Initialize the driver
		SeleniumBase driversetup = new SeleniumBase();
		driversetup.SetupDriver(browserName);
	}

	@AfterTest
	public void afterMethod() {
		//driver.close();
	}

	public WebDriver SetupDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptn = new ChromeOptions();
			chromeoptn.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver getUrl(String key) throws Throwable {
		base_url = ConfigFileReader.getValue(key);
		driver.get(base_url);
		return driver;
	}
	
	
	public void sendKeys(WebElement element,String name) {
		new Actions(driver).sendKeys(element,name).perform();
	}
}
