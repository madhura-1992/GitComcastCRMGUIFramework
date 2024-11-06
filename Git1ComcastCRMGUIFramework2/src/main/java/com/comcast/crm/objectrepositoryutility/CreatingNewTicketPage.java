package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewTicketPage {

	WebDriver driver;
	public CreatingNewTicketPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="ticket_title")
	private WebElement titleEdit;
	
	@FindBy(xpath="//input[@id='parentid']/following-sibling::img")
	private WebElement selectContactPlusIcon;
	
	public void enterTitleAndClickOnSelectContact(String title)
	{
		titleEdit.sendKeys(title);
		selectContactPlusIcon.click();
	}
	
	@FindBy(name="button")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
