package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
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
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
		/**
		 * This is used to initialize the driver
		 * @param browserName
		 * @return it returns the driver
		 */
	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser");
		System.out.println("browser name is : "+ browserName);
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			//driver =new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			//driver =new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			//driver =new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;
		case "safari":
			//driver =new SafariDriver();
			tlDriver.set(new SafariDriver());
			break;
		default:
			System.out.println("please pass the right browser........." +browserName);
			break;
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	/**
	 * This method is used to initialise the properties 
	 * @return
	 */
	public Properties initProp() {

		//mvn clean install -Denv="qa"
		FileInputStream ip=null;
		prop = new Properties();
		
		String envName = System.getProperty("env");
		System.out.println("env name is: " +envName);
		try {
		if(envName==null) {
			System.out.println("no env is given...hence running it on QA env..by default...");
			ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
		}
		else {
			switch (envName.toLowerCase().trim()) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "dev":
				ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "prod":
				ip = new FileInputStream("./src/test/resources/config/config.properties");
				break;
			default:
				System.out.println("please pass the right env name...."+ envName);
				break;
			}
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	} 
	
	/**
	 * take Screenshot
	 * @return 
	 */
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshot/"+methodName+"_"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}

}
