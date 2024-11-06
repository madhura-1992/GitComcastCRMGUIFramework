package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.assertutility.AssertUtility;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public AssertUtility au=new AssertUtility();
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		Reporter.log("==Connect to DB, Report Config==",true);
		dLib.getDbConnection();	
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		Reporter.log("==Launch the Browser==",true);
		String BROWSER=fLib.getDataFromPropertiesFile("Browser");
		driver=wLib.launchBrowser(BROWSER);
		UtilityClassObject.setDriver(driver);
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		Reporter.log("==Login==",true);
		String URL=fLib.getDataFromPropertiesFile("Url");
		String USERNAME=fLib.getDataFromPropertiesFile("Username");
		String PASSWORD=fLib.getDataFromPropertiesFile("Password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() throws Throwable {
		Reporter.log("==Logout==",true);
		HomePage hp=new HomePage(driver);
		Thread.sleep(5000);
		hp.logout();
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		Reporter.log("==Close the Browser==",true);
		driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() {
		Reporter.log("==Close DB, Report Backup==",true);
		dLib.closeDbConnection();
		
	}
}
