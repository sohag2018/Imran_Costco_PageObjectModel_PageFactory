package com.costco.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.costco.qa.base.BaseTest;

public class HomePage extends BaseTest{
	
	
	@FindBy(xpath="//div[@class='table-cell logo hidden-xs hidden-sm hidden-md hidden-lg']//child::img[@class='bc-logo logo-us']")
	WebElement logo;
	
	@FindBy(xpath="//input[@id='search-field']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@type='button']//child::i[@class='co-search-thin']")
	WebElement searchBtn;
	
	@FindBy(id="navigation-dropdown")
	WebElement shopAllDept;
	
	@FindBy(how=How.CSS,using="#Home_Ancillary_0")
	WebElement grocesry;
	
	@FindBy(how=How.CSS,using="#Home_Ancillary_1")
	WebElement businessDelivery;
	
	@FindBy(how=How.CSS,using="#Home_Ancillary_2")
	WebElement optical;
	
	@FindBy(how=How.CSS,using="#Home_Ancillary_3")
	WebElement pharmacy;
	
	@FindBy(how=How.CSS,using="#warehouse-locations-dropdown")
	WebElement FindWarehouses;
	
	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLogo() {
		return logo.isDisplayed();
		
	}
	
	public void searchItem(String item) {
		searchBox.sendKeys(item);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public ShopAllDeptPage getLinkOnShopAllDept() throws IOException {
		Actions action =new Actions(driver);
		action.moveToElement(shopAllDept).build().perform();
		return new ShopAllDeptPage();
	} 
	
//	public GroceryPage getLinkOnGrocery() throws IOException{
//		Actions action=new Actions(driver);
//		action.moveToElement(grocesry).build().perform();
//		return new GroceryPage();
//	}
//	
//	public BusinessDeliveryPage clickOnBusinessDelivery() {
//		Actions action=new Actions(driver);
//		action.moveToElement(businessDelivery).build().perform();
//		return new BusinessDeliveryPage();
//	}
//	
//	public OpticalPage clickOnOptical() {
//		Actions action=new Actions(driver);
//		action.moveToElement(optical).build().perform();
//		return new OpticalPage();
//	}
//	
//	public PharmacyPage clickOnPharmcy() {
//		Actions action =new Actions(driver);
//		action.moveToElement(pharmacy).build().perform();
//		return new PharmacyPage();
//	}
//	
	public FindWarehousesPage clickOnLFindWarehouses() throws IOException {
		FindWarehouses.click();
		return new FindWarehousesPage();
	}

}
