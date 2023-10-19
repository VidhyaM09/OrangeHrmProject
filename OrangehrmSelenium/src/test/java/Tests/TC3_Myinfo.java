package Tests;

import org.testng.annotations.Test;


import Pages.MyinfoPage;

public class TC3_Myinfo{
	
	MyinfoPage myinfopage = new MyinfoPage();

	@Test(priority=2)
	public void goToMyinfoPage() throws InterruptedException {
		myinfopage.clickMyinfo();
		myinfopage.editContactDetails();
		myinfopage.editEmergencyContactDetails();
		//myinfopage.validateEmergencyContact();
	}
}
