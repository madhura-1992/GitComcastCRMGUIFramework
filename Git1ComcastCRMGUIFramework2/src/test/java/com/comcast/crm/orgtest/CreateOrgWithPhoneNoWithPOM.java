package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgWithPhoneNoWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		String phoneno = eLib.getDataFromExcel("Organization", 1, 7);
		
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.CreateOrgWithPhoneNo(orgName,phoneno);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgname = oip.getActOrgName().getText();
		if(actOrgname.equals(orgName))
		{
			System.out.println(orgName+" information is created");
		}else {
			System.out.println(orgName+" information is not created");
		}
		
		String actPhoneno = oip.getActPhoneNo().getText();
		if(actPhoneno.equals(phoneno))
		{
			System.out.println(phoneno+" information is created");
		}else {
			System.out.println(phoneno+" information is not created");
		}
		
		hp.logout();
		
		driver.quit();
	}

}
