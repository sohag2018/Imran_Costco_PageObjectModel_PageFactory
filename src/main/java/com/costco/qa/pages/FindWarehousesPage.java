package com.costco.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.costco.qa.base.BaseTest;

public class FindWarehousesPage extends BaseTest{

	
	
	@FindBy(how=How.CSS,using="#warehouse-search-field-desktop")
	WebElement zipCodeField;
	
	@FindBy(how=How.CSS,using="#hasGas-desktop")
	WebElement gasStationCheckbox;
	
	@FindBy(how=How.XPATH,using="//label[@for='hasTires-desktop'and@title='Tire Service']")
	WebElement TireCenterCheckbox;
	
	@FindBy(how=How.XPATH,using="//label[@for='hasFood-desktop'and @title='Food Court']")
	WebElement foodCourtCheckbox;
	
	@FindBy(how=How.XPATH,using="//label[@for='hasHearing-desktop'and@title='Hearing Aids']")
	WebElement hearingAidsCheckbox;
	
	
	public FindWarehousesPage()throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public void checkAllFieldsOfFindWarehouses(String zipcode) {
		
		gasStationCheckbox.click();
		TireCenterCheckbox.click();
		foodCourtCheckbox.click();
		hearingAidsCheckbox.click();
		zipCodeField.sendKeys(zipcode);
		
		
		
	}
	
	

}
