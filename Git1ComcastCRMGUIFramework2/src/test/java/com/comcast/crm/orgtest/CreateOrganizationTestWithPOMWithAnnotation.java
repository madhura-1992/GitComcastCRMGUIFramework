package com.comcast.crm.orgtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTestWithPOMWithAnnotation extends BaseClass{

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
		if(actOrgName.contains(orgName))
			System.out.println(orgName+" name is verified==PASS");
		else
			System.out.println(orgName+" name is not verified==FAIL");
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
	}
}
