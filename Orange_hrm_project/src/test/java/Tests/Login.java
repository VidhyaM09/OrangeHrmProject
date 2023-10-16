package Tests;

import org.testng.annotations.Test;

import BaseClass.SeleniumBase;
import Pages.LoginPage;

public class Login extends SeleniumBase {

	LoginPage loginpage = new LoginPage();

	@Test(priority = 1)
	public void launchurl() throws Throwable {

		loginpage.launchUrl();
        loginpage.login();
	}
}
