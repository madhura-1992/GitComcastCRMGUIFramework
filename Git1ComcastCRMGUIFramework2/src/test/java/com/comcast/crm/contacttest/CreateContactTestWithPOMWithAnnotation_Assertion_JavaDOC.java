package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsChildTab;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
/**
 * @author Madhura
 */

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)
public class CreateContactTestWithPOMWithAnnotation_Assertion_JavaDOC extends BaseClass {

	@Test(groups="smokeTest")
	public void createContactTest() throws Throwable {
		/* read testScript data from Excel file*/
		String lastName = eLib.getDataFromExcel("Contact", 1, 0) + jLib.getRandomNumber();

		/*navigate to Contact module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/*click on "Create Contact" button*/
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();

		/*enter all the details & create new contact*/
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContact(lastName);

		ContactInformationPage cip = new ContactInformationPage(driver);
		String Headerinfo = cip.getHeaderinfoContact().getText();
		au.hardAssertContains(Headerinfo,lastName);
	
		String actLastName = cip.getLastNameTxt().getText();
		au.softAssertContains(actLastName,lastName);
	}
	
	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
				
		String lastName = eLib.getDataFromExcel("Contact", 1, 0)+jLib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactBtn().click();
	
		CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		cncp.getLastNameEdt().sendKeys(lastName);
		
		String startdate = jLib.getSystemDate();
		String enddate = jLib.getRequiredDate(30);
		
		cncp.supportStartAndEndDate(startdate,enddate);	
		cncp.getSaveBtn().click();
	
		ContactInformationPage cip=new ContactInformationPage(driver);
		String actStartDate = cip.getSupportStartDate().getText();
		au.softAssertContains(actStartDate, startdate);
				
		String actEndDate = cip.getSupportEnddate().getText();
		au.softAssertContains(actEndDate, enddate);
	}
	
	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable
	{
		String lastName = eLib.getDataFromExcel("Contact", 1, 0)+jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("Contact", 1, 1)+jLib.getRandomNumber();
		
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
		au.hardAssertContains(Headerinfo, lastName);
				
		String actOrgname = cip.getActOrgName().getText();
		au.softAssertContains(actOrgname, orgName);
	}
}
