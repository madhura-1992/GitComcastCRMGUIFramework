package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	@FindBy(name="button")
	private WebElement saveBtn;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectIcon;
	
	
	public WebElement getSelectIcon() {
		return selectIcon;
	}

	public void createContact(String lastName)
	{
		driver.manage().window().maximize();
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;
	
	public void supportStartAndEndDate(String startDate,String endDate)
	{
		supportStartDate.clear();
		supportStartDate.sendKeys(startDate);
		supportEndDate.clear();
		supportEndDate.sendKeys(endDate);
	}
}
