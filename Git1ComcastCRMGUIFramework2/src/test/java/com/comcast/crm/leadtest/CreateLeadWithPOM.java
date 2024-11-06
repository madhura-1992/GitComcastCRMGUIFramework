package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationpage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateLeadWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String lastName = eLib.getDataFromExcel("Lead", 1, 0)+jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("Lead", 1, 1)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getLeadsLink().click();
		
		LeadsPage lsp=new LeadsPage(driver);
		lsp.getCreateLeadBtn().click();
		
		CreatingNewLeadPage cnlp=new CreatingNewLeadPage(driver);
		cnlp.createLead(lastName,company);
		
		LeadInformationpage lip=new LeadInformationpage(driver);
		String actLastName = lip.getActLastName().getText();
		if(actLastName.contains(lastName))
			System.out.println(lastName+" information is created");
		else
			System.out.println(lastName+" information is not created");
		
		hp.logout();
		driver.quit();
	}
	

}
