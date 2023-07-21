package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actloginPageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actloginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getLoginPageURLTest() {
		String actURL = loginpage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}
	
	@Test(priority=3)
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	
	@Test(priority=4)
	public void loginTest() {
		accPage=loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
		//Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
		Assert.assertEquals(accPage.isLogoutLinkExist(), true);
	}
	

}
