package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void registerPageSetUp() {
		registerPage=loginpage.navigateToRegisterPage();
	}
	
	@Test
	public void userRegisterTest() {
		Assert.assertTrue(registerPage.registerUser("Naveen", "Testing", "naveen@test.com", "9191919191", "naveen@123", "yes"));
	}
	
}
