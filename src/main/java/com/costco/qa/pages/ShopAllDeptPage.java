package com.costco.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.costco.qa.base.BaseTest;

public class ShopAllDeptPage extends BaseTest{
	@FindBy(xpath="//li[@id='30001']//child::a[text()='Appliances']")
	WebElement appliances;
	
	public ShopAllDeptPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String getShopAllDeptPageTitle() throws InterruptedException {
		appliances.click();
		Thread.sleep(5000);
		return driver.getTitle();
	}

}
