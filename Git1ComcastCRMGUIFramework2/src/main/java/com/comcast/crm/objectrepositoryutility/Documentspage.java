package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Documentspage {

	WebDriver driver;
	public Documentspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement createDocumentBtn;
	public WebElement getCreateDocumentBtn() {
		return createDocumentBtn;
	}
	
	@FindBy(name="notes_title")
	private WebElement titleEdit;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public void enterTitleAndSave(String title)
	{
		titleEdit.sendKeys(title);
		saveBtn.click();
	}
}
