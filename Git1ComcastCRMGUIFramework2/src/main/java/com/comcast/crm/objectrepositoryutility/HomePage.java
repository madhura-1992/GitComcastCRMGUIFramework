package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	public WebElement getDocumentsLink() {
		return documentsLink;
	}
	
	@FindBy(linkText="Vendors")
	private WebElement vendorsLink;
	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLink;
	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	

	public WebElement getProductsLink() {
		return productsLink;
	}

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	public void navigateToCampaignsPage()
	{
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignsLink.click();
	}
	
	public void logout()
	{
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}
}
