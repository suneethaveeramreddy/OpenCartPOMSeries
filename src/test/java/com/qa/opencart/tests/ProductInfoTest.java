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
			{"canon","Canon EOS 5D"}
		};
	}
	@Test(dataProvider="productTestData")
	public void productHeaderTest(String searchKey,String productName) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		String actProductHeader = productInfoPage.getProductHeaderText();
		Assert.assertEquals(actProductHeader, productName);
	}
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"macbook","MacBook Pro",4},
			{"macbook","MacBook Air",4},
			{"iMac","iMac",3},
			{"samsung","Samsung Galaxy Tab 10.1",7},
			{"samsung","Samsung SyncMaster 941BW",1},
			{"canon","Canon EOS 5D",3}
		};
	}
	
	@Test(dataProvider="productData")
	public void productImagesCountTest(String searchKey, String productName, int expProductImagesCount) {
		searchResPage = accPage.doSearch(searchKey);
		productInfoPage = searchResPage.selectProduct(productName);
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actProductImagesCount, expProductImagesCount);
	}

}
