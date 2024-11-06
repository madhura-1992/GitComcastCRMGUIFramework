package com.comcast.crm.troubletickettest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsChildTabPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewTicketPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketsInformationPage;
import com.comcast.crm.objectrepositoryutility.TroubleTicketsPage;

public class CreateTroubleTicketWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="regressionTest")
	public void createTroubleTicketTest() throws Throwable {
		
		String title = eLib.getDataFromExcel("TroubleTicket", 1, 0)+jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("TroubleTicket", 1, 1)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.createContact(lastName);		
		
		hp.getTroubleTicketsLink().click();
		
		TroubleTicketsPage ttp=new TroubleTicketsPage(driver);
		ttp.getCreateTicketBtn().click();
		
		CreatingNewTicketPage cntp=new CreatingNewTicketPage(driver);
		cntp.enterTitleAndClickOnSelectContact(title);
				
		wLib.switchToTabOnURL(driver,"Contacts&action");
		
		ContactsChildTabPage cctp=new ContactsChildTabPage(driver);
		cctp.searchContact(lastName);
		
		driver.findElement(By.xpath("//a[text()=' "+lastName+"']")).click();
		
		wLib.switchToTabOnURL(driver,"HelpDesk&action");
		
		cntp.getSaveBtn().click();
	
		TroubleTicketsInformationPage ttip=new TroubleTicketsInformationPage(driver);
		String headerinfo = ttip.getHeaderInformation().getText();
		au.hardAssertContains(headerinfo, title);
						
		String actContact = ttip.getContactName().getText();
		au.softAssertContains(actContact, lastName);
	}
}