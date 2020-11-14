package com.costco.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.costco.qa.base.BaseTest;
import com.costco.qa.pages.FindWarehousesPage;
import com.costco.qa.pages.HomePage;

public class FindWarehousesPageTest extends BaseTest {
	public HomePage hm;
	public FindWarehousesPage fwp;

	public FindWarehousesPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		hm=new HomePage();
		fwp=hm.clickOnLFindWarehouses();
		
	}
	
	
	@Test
	public void findWarehouse() {
		fwp.checkAllFieldsOfFindWarehouses("11377");
		driver.navigate().back();
		String homepageTitle=driver.getTitle();
		Assert.assertEquals(homepageTitle, "Welcome to Costco Wholesale");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
