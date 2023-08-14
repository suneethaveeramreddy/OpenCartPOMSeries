package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/**
 * 
 * @author sunee
 *
 */
public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	
	
		/**
		 * This is used to initialize the driver
		 * @param browserName
		 * @return it returns the driver
		 */
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is : "+ browserName);
		optionsManager = new OptionsManager(prop);
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver =new ChromeDriver(optionsManager.getChromeOptions());
			break;
		case "firefox":
			driver =new FirefoxDriver(optionsManager.getFirefoxOptions());
			break;
		case "edge":
			driver =new EdgeDriver(optionsManager.getEdgeOptions());
			break;
		case "safari":
			driver =new SafariDriver();
			break;
		default:
			System.out.println("please pass the right browser........." +browserName);
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	/**
	 * This method is used to initialise the properties 
	 * @return
	 */
	public Properties initProp() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	} 

}
