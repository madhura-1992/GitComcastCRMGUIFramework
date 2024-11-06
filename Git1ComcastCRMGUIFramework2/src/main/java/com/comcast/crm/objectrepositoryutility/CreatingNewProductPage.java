package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameEdit;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public void createProduct(String productName)
	{
		productNameEdit.sendKeys(productName);
		saveBtn.click();
	}
}
