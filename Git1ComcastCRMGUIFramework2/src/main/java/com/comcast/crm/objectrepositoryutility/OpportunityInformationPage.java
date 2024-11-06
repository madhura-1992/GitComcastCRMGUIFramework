package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {

	WebDriver driver;
	public OpportunityInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfoOpportunity;
	public WebElement getHeaderInfoOpportunity() {
		return headerInfoOpportunity;
	}
	
	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement actOrgName;
	public WebElement getActOrgName() {
		return actOrgName;
	}
	
	
}
