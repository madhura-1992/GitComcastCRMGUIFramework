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

public class CreateOrgWithIndustryWithPOM {

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
		String industry = eLib.getDataFromExcel("Organization", 1, 3);
		String type = eLib.getDataFromExcel("Organization", 1, 4);
		
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
		cnop.CreateOrg(orgName,industry,type);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgname = oip.getActOrgName().getText();
		
		if(orgName.equals(actOrgname))
			System.out.println(orgName+" organization is created");
		else
			System.out.println(orgName+" organization is not created");
		
		String actIndustry = oip.getActIndustry().getText();
		if(industry.equals(actIndustry))
			System.out.println(industry+" industry is created");
		else
			System.out.println(industry+" industry is not created");
		
		String actType = oip.getActType().getText();
		if(type.equals(actType))
			System.out.println(type+" type is created");
		else
			System.out.println(type+" is not created");
		
		hp.logout();
		
		driver.quit();
	}

}
