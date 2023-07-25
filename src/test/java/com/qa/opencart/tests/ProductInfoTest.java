package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class ProductInfoTest extends BaseTest{

	@BeforeClass
	public void prodInfoSetUp() {
		accPage = loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
	}
	
	@DataProvider
	public Object[][] productTestData() {
		return new Object[][] {
			{"macbook","MacBook Pro"},
			{"macbook","MacBook Air"},
			{"iMac","iMac"},
			{"samsung","Samsung Galaxy Tab 10.1"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"canon",1}
		};
	}
	@Test(dataProvider="productTestData")
	public void productHeaderTest(String searchKey,String productName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		String actProductHeader = productInfoPage.getProductHeaderText();
		Assert.assertEquals(actProductHeader, productName);
	}
	
	@Test
	public void productImagesCountTest() {
		searchResPage = accPage.doSearch("macbook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actProductImagesCount, 4);
		
	}

}
