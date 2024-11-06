package com.comcast.crm.vendortest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewVendorPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.VendorInformationPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

public class CreateVendorWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="regressionTest")
	public void createVendorTest() throws Throwable {
		
		String vendorname = eLib.getDataFromExcel("Vendor", 1, 0)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		hp.getVendorsLink().click();
		
		VendorsPage vp=new VendorsPage(driver);
		vp.getCreateVendorIcon().click();
		
		CreatingNewVendorPage cnvp=new CreatingNewVendorPage(driver);
		cnvp.createvendor(vendorname);
				
		VendorInformationPage vip=new VendorInformationPage(driver);
		String actVendorName = vip.getActVendorName().getText();
		au.hardAssertEquals(actVendorName, vendorname);
	}
}
