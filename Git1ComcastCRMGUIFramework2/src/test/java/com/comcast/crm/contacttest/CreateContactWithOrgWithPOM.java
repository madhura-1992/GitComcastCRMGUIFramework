package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsChildTab;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String lastName = eLib.getDataFromExcel("Contact", 1, 0)+jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
				
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
		hp.getContactLink().click();
	
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
		
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);
		cncp.getSelectIcon().click();
		
		wLib.switchToTabOnURL(driver,"Accounts&action");
		
		OrganizationsChildTab oct=new OrganizationsChildTab(driver);
		oct.searchOrg(orgName);
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
		wLib.switchToTabOnURL(driver,"Contacts&action");
		
		cncp.getSaveBtn().click();
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String Headerinfo = cip.getHeaderinfoContact().getText();
		if(Headerinfo.contains(lastName)) {
			System.out.println(lastName+" header is verified==PASS");
		}else {
			System.out.println(lastName+" header is not verified==FAIL");
		}
		
		String actOrgname = cip.getActOrgName().getText();
		if(actOrgname.trim().equals(orgName))
		{
			System.out.println(orgName+" information is created");
		}else {
			System.out.println(orgName+" information is not created");
		}
		driver.quit();
		
	}

}
