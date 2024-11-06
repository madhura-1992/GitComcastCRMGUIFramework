package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTestWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable {
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
		cp.CreateOrg(orgName);
		
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
