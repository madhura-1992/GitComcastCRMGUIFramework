package com.comcast.crm.opportunitytest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOpportunityPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OpportunitiesPage;
import com.comcast.crm.objectrepositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsChildTab;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOpportunityWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="smokeTest")
	public void createOpportunityTest() throws Throwable {
			
		String orgName = eLib.getDataFromExcel("Opportunity", 1, 0)+jLib.getRandomNumber();
		String oppName = eLib.getDataFromExcel("Opportunity", 1, 1)+jLib.getRandomNumber();
		
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
		au.hardAssertContains(headerinfo, oppName);		
		
		String actOrgName = oip.getActOrgName().getText();
		au.softAssertEquals(actOrgName, orgName);
			
	}
}



