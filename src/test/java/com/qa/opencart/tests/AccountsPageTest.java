package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass()
		public void getLoginPageSetUp() {
		accPage = loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
		}
	
	@Test
	public void accPageTitleTest() {
		String actAccPageTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actAccPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	public void logoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	
	public void accPageHeadersCountTest() {
		int actAccPageHeadersCount = accPage.getAccountsPageHeaderCount();
		System.out.println("Actual Acc Page Header count=" +actAccPageHeadersCount);
		Assert.assertEquals(actAccPageHeadersCount, AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	
}
