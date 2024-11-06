package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunityPage {
	
	WebDriver driver;
	public CreatingNewOpportunityPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="potentialname")
	private WebElement opportunityNameEdit;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectIcon;
	
	public void enterOppNameAndClickOnOrgPlusIcon(String oppName) 
	{
		opportunityNameEdit.sendKeys(oppName);
		selectIcon.click();
	}
	
	@FindBy(name="button")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
