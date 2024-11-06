package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actOrgName;
	public WebElement getActOrgName() {
		return actOrgName;
	}
	
	@FindBy(id="dtlview_Industry")
	private WebElement actIndustry;
	public WebElement getActIndustry() {
		return actIndustry;
	}
	
	@FindBy(id="dtlview_Type")
	private WebElement actType;
	public WebElement getActType() {
		return actType;
	}
	
	@FindBy(id="dtlview_Phone")
	private WebElement actPhoneNo;
	public WebElement getActPhoneNo() {
		return actPhoneNo;
	}
	
	
}
