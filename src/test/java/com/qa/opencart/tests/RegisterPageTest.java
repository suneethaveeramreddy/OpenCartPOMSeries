package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


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
	
	@Test(dataProvider="getUserRegData")
	public void userRegisterTest(String firstName,String lastName,String Telephone, String password, String subscribe) {
		Assert.assertTrue(registerPage.registerUser(firstName, lastName, getRandomEmailID(), Telephone, password, subscribe));
	}
	
}
