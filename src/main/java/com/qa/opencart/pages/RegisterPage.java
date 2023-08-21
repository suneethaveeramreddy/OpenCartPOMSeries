package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By firstName		=	By.id("input-firstname");
	private By lastName			= 	By.id("input-lastname");
	private By emailID			=	By.id("input-email");
	private By telephone		= 	By.id("input-telephone");
	private By password			=	By.id("input-password");
	private By confirmpwd		=	By.id("input-confirm");
	private By subscribeYes		= 	By.xpath("//label[@class='radio-inline'][position()=1]/input[@type='radio']"); //label[@class='radio-inline'][1]/input[@type='radio']
	private By subscribeNo		= 	By.xpath("//label[normalize-space()='No']");
	private By agreeCheckBox	=   By.xpath("//input[@type='checkbox']");	
	private By continueBtn		=  	By.xpath("//input[@type='submit']");
	private By successMessg		= 	By.cssSelector("div#content h1");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil =new ElementUtil(driver);
	}
	
	public boolean registerUser(String firstName, String lastName, String emailID,String telephone,String password,String subscribe) {
		eleUtil.waitForElementVisible(this.firstName, AppConstants.MEDIUM_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.emailID, emailID);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpwd, password);
		if(subscribe.equalsIgnoreCase("yes")) {
			eleUtil.doClick(subscribeYes);
		}
		else{
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.doClick(agreeCheckBox);
		eleUtil.doClick(continueBtn);
		String successMessg = eleUtil.waitForElementVisible(this.successMessg, AppConstants.LONG_TIME_OUT).getText();
		System.out.println(successMessg);
		if(successMessg.contains(AppConstants.USER_REGISTER_SUCCESS_MESSG)) {
			return true;
		}
		return false;
	}

}
