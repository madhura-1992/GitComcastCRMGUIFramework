package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactwithSupportDateWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String lastName = eLib.getDataFromExcel("Contact", 1, 0)+jLib.getRandomNumber();
		
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
		cncp.getLastNameEdt().sendKeys(lastName);
		
		
		String startdate = jLib.getSystemDate();
		String enddate = jLib.getRequiredDate(30);
		
		cncp.supportStartAndEndDate(startdate,enddate);	
		cncp.getSaveBtn().click();
	
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actStartDate = cip.getSupportStartDate().getText();
		if(actStartDate.equals(startdate))
			System.out.println(startdate+" is created");
		else
			System.out.println(startdate+" is not created");
		
		String actEndDate = cip.getSupportEnddate().getText();
		if(actEndDate.equals(enddate))
			System.out.println(enddate+" is created");
		else
			System.out.println(enddate+" is not created");
		
		driver.quit();
	}

}
