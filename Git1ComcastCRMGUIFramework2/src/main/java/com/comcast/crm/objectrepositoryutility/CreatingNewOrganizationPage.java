package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	@FindBy(name="button")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(name="industry")
	private WebElement industryDd;
	public WebElement getIndustryDd() {
		return industryDd;
	}	
	
	@FindBy(name="accounttype")
	private WebElement typeDd;
	public WebElement getTypeDd() {
		return typeDd;
	}
	
	@FindBy(id="phone")
	private WebElement phoneNoEdit;
	public WebElement getPhoneNoEdit() {
		return phoneNoEdit;
	}

	public void CreateOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void CreateOrg(String orgName,String industry)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDd);
		sel.selectByVisibleText(industry);		
		saveBtn.click();
	}
	
	public void CreateOrg(String orgName,String industry,String type)
	{
		orgNameEdt.sendKeys(orgName);
		Select sel=new Select(industryDd);
		sel.selectByVisibleText(industry);
		Select sel1=new Select(typeDd);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	
	public void CreateOrgWithPhoneNo(String orgName,String phoneNo)
	{
		orgNameEdt.sendKeys(orgName);
		phoneNoEdit.sendKeys(phoneNo);
		saveBtn.click();
	}
}
