package Tests;


import org.testng.annotations.Test;

import BasePackage.SeleniumBase;
import Pages.LoginPage;

public class TC1_Login extends SeleniumBase {
	
	LoginPage loginpage = new LoginPage();

	@Test(priority=1)
	public void launchurl() throws Throwable {

		loginpage.launchUrl();
		loginpage.enterUsername();
		loginpage.enterPassword();
		loginpage.clickLoginBtn();

	}
}
