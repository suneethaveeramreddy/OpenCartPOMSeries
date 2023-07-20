package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink=By.linkText("Logout");
	private By accHeaders=By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		//eleUtil = new ElementUtil(driver);
	}
	
	public String getAccPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementPresence(logoutLink, AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageHeader() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(accHeaders, AppConstants.MEDIUM_TIME_OUT);
		List<String> headersValueList= new ArrayList<String>();
		for (WebElement e:headersList) {
			String headerText=e.getText();
			headersValueList.add(headerText);
		}
		return headersValueList;
	}
	public int getAccountsPageHeaderCount() {
		return getAccountsPageHeader().size();
	}
}
