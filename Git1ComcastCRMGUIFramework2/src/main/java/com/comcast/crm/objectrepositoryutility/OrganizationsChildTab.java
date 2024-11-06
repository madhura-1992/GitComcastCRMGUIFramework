package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsChildTab {

	WebDriver driver;
	public OrganizationsChildTab(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchEdit;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public void searchOrg(String orgName)
	{
		searchEdit.sendKeys(orgName);
		searchBtn.click();
	}
}
