package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {

	WebDriver driver;
	public DocumentInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Title")
	private WebElement headerinfodocument;
	public WebElement getHeaderinfodocument() {
		return headerinfodocument;
	}
	
}
