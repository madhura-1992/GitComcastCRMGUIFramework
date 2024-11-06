package com.comcast.crm.documenttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.DocumentInformationPage;
import com.comcast.crm.objectrepositoryutility.Documentspage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateDocumentWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="smokeTest")
	public void createDocument() throws Throwable {
			
		String title = eLib.getDataFromExcel("Document", 1, 0)+jLib.getRandomNumber();
				
		HomePage hp=new HomePage(driver);
		hp.getDocumentsLink().click();
		
		Documentspage dp=new Documentspage(driver);
		dp.getCreateDocumentBtn().click();
		dp.enterTitleAndSave(title);
		
		DocumentInformationPage dip=new DocumentInformationPage(driver);
		String acttitle = dip.getHeaderinfodocument().getText();
		au.hardAssertEquals(acttitle, title);
		
	}
}
