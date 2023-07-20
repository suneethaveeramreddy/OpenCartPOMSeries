package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
		private WebDriver driver;
		private ElementUtil eleUtil;
	
	//1. By locators - page locators
	private By emailID 		= By.id("input-email");
	private By password 	= By.id("input-password");
	private By forgotpwdLink	= By.linkText("Forgotten Password"); 
	private By loginBtn		= By.xpath("//input[@type='submit']");
	
	
	//2. Page Constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
	
	//3. Public Page actions/methods 
	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login page title is: " +title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_TIME_OUT);
		System.out.println("Login page url is: " + url);
		return url;
	}
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotpwdLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public String doLogin(String username, String pwd) {
		System.out.println("App credentials are: " + username + ":" +pwd);
		eleUtil.waitForElementVisible(emailID, AppConstants.MEDIUM_TIME_OUT).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
	}

}
