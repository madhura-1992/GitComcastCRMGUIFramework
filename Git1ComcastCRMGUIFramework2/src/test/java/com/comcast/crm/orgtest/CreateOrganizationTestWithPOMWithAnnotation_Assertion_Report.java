package com.comcast.crm.orgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImplementationClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
class CreateOrganizationTestWithPOMWithAnnotation_Assertion_Report extends BaseClass{

	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create new Org page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
		cp.CreateOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName+"==>org is created");
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		au.hardAssertContains(actOrgName, orgName);
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithIndustryTest() throws Throwable {
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Organization", 1, 3);
		String type = eLib.getDataFromExcel("Organization", 1, 4);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();	
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.CreateOrg(orgName,industry,type);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgname = oip.getActOrgName().getText();
		au.hardAssertEquals(actOrgname, orgName);
			
		String actIndustry = oip.getActIndustry().getText();
		au.softAssertEquals(actIndustry, industry);
				
		String actType = oip.getActType().getText();
		au.softAssertEquals(actType, type);
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithPhoneNoTest() throws Throwable {
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		String phoneno = eLib.getDataFromExcel("Organization", 1, 7);
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.CreateOrgWithPhoneNo(orgName,phoneno);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String actOrgname = oip.getActOrgName().getText();
		au.hardAssertEquals(actOrgname, orgName);
				
		String actPhoneno = oip.getActPhoneNo().getText();
		au.softAssertEquals(actPhoneno, phoneno);
	}
}
