package com.comcast.crm.troubletickettest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

public class CreateTroubleTicketWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String title = eLib.getDataFromExcel("TroubleTicket", 1, 0)+jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("TroubleTicket", 1, 1)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
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
		if(headerinfo.contains(title))
			System.out.println("trouble ticket is raised successfully");
		else
			System.out.println("trouble ticket is not raised");
		
		String actContact = ttip.getContactName().getText();
		if(actContact.trim().equals(lastName))
			System.out.println(lastName+" information is successfully created");
		else
			System.out.println(lastName+" information is not created");
		
		hp.logout();
		
		driver.quit();
	}

}
