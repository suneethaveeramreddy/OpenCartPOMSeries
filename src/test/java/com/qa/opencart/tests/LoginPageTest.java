package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actloginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actloginPageTitle, "Account Login");
	}
	
	@Test(priority=2)
	public void getLoginPageURLTest() {
		String actURL = loginpage.getLoginPageURL();
		Assert.assertTrue(actURL.contains("route=account/login"));
	}
	
	@Test(priority=3)
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	
	@Test(priority=4)
	public void loginTest() {
		String accPageTitle = loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
		Assert.assertEquals(accPageTitle, "My Account");
	}
	

}
