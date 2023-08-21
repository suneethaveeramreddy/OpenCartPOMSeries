package com.qa.opencart.tests;

import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.RegisterPage;

public class RegisterPageTest extends BaseTest{
	
	@Test(priority=1)
	public void subscribeYesTest() {
		registerPage.clickYes();
	}
}
