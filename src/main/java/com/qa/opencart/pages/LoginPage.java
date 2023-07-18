package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		private WebDriver driver;
	
	//1. By locators - page locators
	private By emailID 		= By.id("input-email");
	private By password 	= By.id("input-password");
	private By forgotpwd	= By.linkText("Forgotten Password"); 
	private By loginBtn		= By.xpath("//input[@type='submit']");
	
	
	//2. Page Constructor 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3. Public Page actions/methods 
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title is: " +title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login page url is: " +url);
		return url;
	}

}
