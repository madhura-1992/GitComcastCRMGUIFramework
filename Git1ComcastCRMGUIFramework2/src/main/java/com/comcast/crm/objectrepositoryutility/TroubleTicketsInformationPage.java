package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsInformationPage {

	WebDriver driver;
	public TroubleTicketsInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInformation;
	public WebElement getHeaderInformation() {
		return headerInformation;
	}
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/a")
	private WebElement contactName;
	public WebElement getContactName() {
		return contactName;
	}
	
}
