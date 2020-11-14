package com.costco.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.costco.qa.base.BaseTest;
import com.costco.qa.pages.HomePage;
import com.costco.qa.pages.ShopAllDeptPage;

public class ShopAllDeptPageTest extends BaseTest {
	HomePage hm;
	ShopAllDeptPage sadp;

	public ShopAllDeptPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		hm=new HomePage();
		sadp=hm.getLinkOnShopAllDept();

	}

	@Test
	public void verifyShopAllDeptPageTitle() throws InterruptedException {
		String actualTitle=sadp.getShopAllDeptPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, prop.getProperty("AppliancesPageTitle") );
		
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
