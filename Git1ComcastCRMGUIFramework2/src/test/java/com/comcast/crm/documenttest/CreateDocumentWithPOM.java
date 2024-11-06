package com.comcast.crm.documenttest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.DocumentInformationPage;
import com.comcast.crm.objectrepositoryutility.Documentspage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateDocumentWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String title = eLib.getDataFromExcel("Document", 1, 0)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
				
		HomePage hp=new HomePage(driver);
		hp.getDocumentsLink().click();
		
		Documentspage dp=new Documentspage(driver);
		dp.getCreateDocumentBtn().click();
		dp.enterTitleAndSave(title);
		
		DocumentInformationPage dip=new DocumentInformationPage(driver);
		String acttitle = dip.getHeaderinfodocument().getText();
		if(title.equals(acttitle))
			System.out.println("Document is created successfully");
		else
			System.out.println("Document is not created");
		
		driver.quit();
	}

}
