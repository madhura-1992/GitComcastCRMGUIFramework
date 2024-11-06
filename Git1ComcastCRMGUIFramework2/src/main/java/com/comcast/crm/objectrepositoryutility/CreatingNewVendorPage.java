package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendorPage {

	WebDriver driver;
	public CreatingNewVendorPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="vendorname")
	private WebElement vendorNameEdit;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public void createvendor(String vendorName)
	{
		vendorNameEdit.sendKeys(vendorName);
		saveBtn.click();
	}
}
