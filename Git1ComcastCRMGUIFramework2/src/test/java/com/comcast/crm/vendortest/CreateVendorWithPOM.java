package com.comcast.crm.vendortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewVendorPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.VendorInformationPage;
import com.comcast.crm.objectrepositoryutility.VendorsPage;

public class CreateVendorWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String vendorname = eLib.getDataFromExcel("Vendor", 1, 0)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
				
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getMoreLink().click();
		hp.getVendorsLink().click();
		
		VendorsPage vp=new VendorsPage(driver);
		vp.getCreateVendorIcon().click();
		
		CreatingNewVendorPage cnvp=new CreatingNewVendorPage(driver);
		cnvp.createvendor(vendorname);
				
		VendorInformationPage vip=new VendorInformationPage(driver);
		String actVendorName = vip.getActVendorName().getText();
		if(actVendorName.equals(vendorname))
			System.out.println(vendorname+" vendor information is successfully created");
		else
			System.out.println(vendorname+" vendor information is not created");
		
		hp.logout();
		
		driver.quit();
	}

}
