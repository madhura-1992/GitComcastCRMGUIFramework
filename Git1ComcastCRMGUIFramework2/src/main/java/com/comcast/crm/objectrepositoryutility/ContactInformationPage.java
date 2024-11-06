package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerinfoContact;
	public WebElement getHeaderinfoContact() {
		return headerinfoContact;
	}
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameTxt;
	public WebElement getLastNameTxt() {
		return lastNameTxt;
	}
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement actOrgName;
	public WebElement getActOrgName() {
		return actOrgName;
	}
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportStartDate;
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEnddate;
	public WebElement getSupportEnddate() {
		return supportEnddate;
	}
	
	
	
}
