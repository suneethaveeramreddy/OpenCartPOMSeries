package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName	=	By.id("input-firstname");
	private By lastname		= 	By.id("input-lastname");
	private By emailID		=	By.id("input-email");
	private By telephone	= 	By.id("input-telephone");
	private By password		=	By.id("input-password");
	private By confirmpwd	=	By.id("input-confirm");
	private By subscribeYes	= 	By.linkText("Yes");

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
	
	public void clickYes() {
		eleUtil.doClick(subscribeYes);
	}

}
