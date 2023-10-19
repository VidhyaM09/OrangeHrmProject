package BasePackage;

import java.time.Duration;

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

import Utilities.ConfigReader;

public class SeleniumBase {

	String url;
	public static WebDriver driver;
	String title;
	static String browserName;
	private static SeleniumBase seleniumBase;

	@BeforeTest
	public void beforeMethod() throws Throwable {
		browserName = ConfigReader.getValue("browserName");
		// Initialize the driver
		seleniumBase = new SeleniumBase();
		seleniumBase.setDriver(browserName);
	}

	@AfterTest
	public void afterTest() {
		//seleniumBase.closeApp();
	}

	public WebDriver setDriver(String browserName) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/src/test/resources/drivers/chromedriver.exe");
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (browserName.equalsIgnoreCase("fireFox"))
			driver = new FirefoxDriver();
		if (browserName.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getdriver() {
		return driver;
	}

	public WebDriver getUrl(String key) throws Throwable {
		url = ConfigReader.getValue(key);
		driver.get(url);
		return driver;
	}

	public void sendKeys(WebElement element, String name) {
		new Actions(driver).sendKeys(element, name).perform();
	}
	public void closeApp() {
		driver.close();
	}
}
