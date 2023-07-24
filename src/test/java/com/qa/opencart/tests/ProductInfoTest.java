package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class ProductInfoTest extends BaseTest{

	@BeforeClass
	public void prodInfoSetUp() {
		accPage = loginpage.doLogin("janautomation@gmail.com", "Selenium@12345");
	}
	
	@Test
	public void productHeaderTest() {
		searchResPage = accPage.doSearch("macbook");
		productInfoPage = searchResPage.selectProduct("MacBook Pro");
		String actProductHeader = productInfoPage.getProductHeaderText();
		Assert.assertEquals(actProductHeader, "MacBook Pro");
	}

}
