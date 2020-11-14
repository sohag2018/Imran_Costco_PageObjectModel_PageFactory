package com.costco.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.costco.qa.base.BaseTest;
import com.costco.qa.pages.HomePage;

public class HomePageTest extends BaseTest {
	
	HomePage hm;

	public HomePageTest() throws IOException {
		super();
		}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		hm=new HomePage();
	}
	
	
	@Test
	public void logoTest() {
		exTest=extent.createTest("logoTest");
		hm.verifyLogo();
		Assert.assertTrue(true, "Logo is not displayed");
		//logger.info("Logo is visible");
	}
	
	@Test
	public void searchBoxTest() {
		exTest=extent.createTest("searchBoxTest");
		hm.searchItem(prop.getProperty("itemSearch"));
		hm.clickSearchBtn();
		Assert.assertEquals("Welcome to Costco Wholesale", driver.getTitle());
		//logger.info("Item searched successfully");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
