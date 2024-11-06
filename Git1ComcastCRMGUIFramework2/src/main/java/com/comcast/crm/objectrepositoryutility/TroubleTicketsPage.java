package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketsPage {

	WebDriver driver;
	public TroubleTicketsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Ticket...']")
	private WebElement createTicketBtn;
	public WebElement getCreateTicketBtn() {
		return createTicketBtn;
	}
	
}
