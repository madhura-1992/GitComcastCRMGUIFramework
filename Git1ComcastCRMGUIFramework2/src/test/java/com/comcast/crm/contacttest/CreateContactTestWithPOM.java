package com.comcast.crm.contacttest;

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

public class CreateContactTestWithPOM {

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
		cncp.createContact(lastName);
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String Headerinfo = cip.getHeaderinfoContact().getText();
		
		if(Headerinfo.contains(lastName))
			System.out.println(lastName+" header is created successfully");
		else
			System.out.println(lastName+" header is not created");
	
		String actLastName = cip.getLastNameTxt().getText();
		if(actLastName.equals(lastName))
			System.out.println(lastName+" information is created");
		else
			System.out.println(lastName+" information is not created");
		
		driver.quit();
	}
}
