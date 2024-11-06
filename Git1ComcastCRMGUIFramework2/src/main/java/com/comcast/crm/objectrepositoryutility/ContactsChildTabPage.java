package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsChildTabPage {

	WebDriver driver;
	public ContactsChildTabPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchEdit;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public void searchContact(String lastName)
	{
		searchEdit.sendKeys(lastName);
		searchBtn.click();
	}
	
	
	
}
