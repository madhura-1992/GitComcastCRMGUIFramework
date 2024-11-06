package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	WebDriver driver;
	public CreatingNewLeadPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name="company")
	private WebElement companyEdit;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public void createLead(String lastName,String company)
	{
		lastNameEdit.sendKeys(lastName);
		companyEdit.sendKeys(company);
		saveBtn.click();
	}
}
