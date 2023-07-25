package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By productHeader =By.cssSelector("div#content h1");
	private By productImages =By.cssSelector("ul.thumbnails img");
	private By quantity = By.name("quantity");
	private By addToCartBtn	= By.linkText("Add to Cart");

	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getProductHeaderText() {
		return eleUtil.doElementGetText(productHeader);
	}
	
	public int getProductImagesCount() {
		int actProductImagesCount=eleUtil.waitForElementsVisible(productImages, AppConstants.MEDIUM_TIME_OUT).size();
		System.out.println("total product images for :" +getProductHeaderText() + "===>" + actProductImagesCount);
		return actProductImagesCount;
	}
 
}
