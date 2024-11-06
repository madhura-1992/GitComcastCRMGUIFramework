package com.comcast.crm.opportunitytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsChildTab;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOpportunityWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String orgName = eLib.getDataFromExcel("Opportunity", 1, 0)+jLib.getRandomNumber();
		String oppName = eLib.getDataFromExcel("Opportunity", 1, 1)+jLib.getRandomNumber();
		
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.CreateOrg(orgName);
		
		Thread.sleep(3000);
		hp.getOpportunitiesLink().click();
		
		OpportunitiesPage osp=new OpportunitiesPage(driver);
		osp.getCreateOpportunityBtn().click();
		
		CreatingNewOpportunityPage cnosp=new CreatingNewOpportunityPage(driver);
		cnosp.enterOppNameAndClickOnOrgPlusIcon(oppName);
		
		wLib.switchToTabOnURL(driver,"Accounts&action");
		
		OrganizationsChildTab oct=new OrganizationsChildTab(driver);
		oct.searchOrg(orgName);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
					
		wLib.switchToTabOnURL(driver,"Potentials&action");
		
		cnop.getSaveBtn().click();
				
		OpportunityInformationPage oip=new OpportunityInformationPage(driver);
		String headerinfo = oip.getHeaderInfoOpportunity().getText();
		if(headerinfo.contains(oppName))
			System.out.println(oppName+" header information is verified");
		else
			System.out.println(oppName+" header information is not verified");
		
		String actOrgName = oip.getActOrgName().getText();
		if(actOrgName.equals(orgName))
			System.out.println(orgName+" information is created");
		else
			System.out.println(orgName+" information is not created");
		
		hp.logout();
			
		driver.quit();
	}
}



