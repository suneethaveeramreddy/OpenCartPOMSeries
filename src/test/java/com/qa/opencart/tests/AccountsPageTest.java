package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


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
	@Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test
	public void accPageHeadersCountTest() {
		int actAccPageHeadersCount = accPage.getAccountsPageHeaderCount();
		System.out.println("Actual Acc Page Header count=" +actAccPageHeadersCount);
		Assert.assertEquals(actAccPageHeadersCount, AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	@Test
	public void accPageHeadersTest() {
		List<String> actAccPageHeaderList = accPage.getAccountsPageHeader();
		Assert.assertEquals(actAccPageHeaderList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
	}
	
	@DataProvider
	public Object[][] getSearchKey() {
		return new Object[][] {
			{"macbook",3},
				{"imac",1},
				{"samsung",2},
					{"canon",1}
		};
	}
	
	@Test(dataProvider="getSearchKey")
	public void searchTest(String searchKey, int expProductCount) {
		searchResPage  = accPage.doSearch(searchKey);
		int actResultsCount = searchResPage.getSearchProductResultsCount();
		Assert.assertEquals(actResultsCount, expProductCount);
	}
	
	
}
