package com.qa.opencart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	WebDriver driver;
	protected LoginPage loginpage;
	protected AccountsPage accPage;
	protected SearchResultsPage searchResPage;
	protected ProductInfoPage productInfoPage;
	DriverFactory df;
		
	@BeforeTest()
	public void setUp() {
		df=new DriverFactory();
		driver=df.initDriver("chrome");
		loginpage = new LoginPage(driver);
	}
	
	@AfterTest()
	public void tearDown() {
		driver.quit();
	}

}
