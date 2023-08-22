package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;


public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetUp() {
		registerPage=loginpage.navigateToRegisterPage();
	}
	
	public String getRandomEmailID() {
		return "openauto"+System.currentTimeMillis()+"@open.com";
	}
	
	@DataProvider
	public Object[][] getUserRegData() {
		return new Object[][] {
			{"Swecha","Antara","9090909024","swecha@123","yes"},
			{"Subbu","Venkata","9090909012","subbu@123","no"},
			{"suneetha","Veeram","9090909023","sunee@123","yes"}
		};
	}
	
	@DataProvider
	public Object[][] getUserRegSheetData() {
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider="getUserRegSheetData")
	public void userRegisterTest(String firstName,String lastName,String telephone, String password, String subscribe) {
		Assert.assertTrue(registerPage.registerUser(firstName, lastName, getRandomEmailID(), telephone, password, subscribe));
	}
	
}
