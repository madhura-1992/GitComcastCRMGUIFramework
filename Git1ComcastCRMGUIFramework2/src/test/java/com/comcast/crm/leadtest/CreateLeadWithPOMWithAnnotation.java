package com.comcast.crm.leadtest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewLeadPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LeadInformationpage;
import com.comcast.crm.objectrepositoryutility.LeadsPage;

public class CreateLeadWithPOMWithAnnotation extends BaseClass{

	@Test
	public void createLead() throws Throwable {
		
		String lastName = eLib.getDataFromExcel("Lead", 1, 0)+jLib.getRandomNumber();
		String company = eLib.getDataFromExcel("Lead", 1, 1)+jLib.getRandomNumber();
		
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
	}
}
