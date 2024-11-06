package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrgWithIndustry {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String orgName = eLib.getDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("Organization", 1, 3);
		String type = eLib.getDataFromExcel("Organization", 1, 4);
		
		WebDriver driver = wLib.launchBrowser("BROWSER");
		
		driver.manage().window().maximize();
		
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		driver.findElement(By.name("industry")).sendKeys(industry);
		driver.findElement(By.name("accounttype")).sendKeys(type);
		driver.findElement(By.name("button")).click();
		
		String actOrgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if(orgName.equals(actOrgname))
			System.out.println(orgName+" organization is created");
		else
			System.out.println(orgName+" organization is not created");
		
		if(industry.equals(actIndustry))
			System.out.println(industry+" industry is created");
		else
			System.out.println(industry+" industry is not created");
		
		if(type.equals(actType))
			System.out.println(type+" type is created");
		else
			System.out.println(type+" is not created");
		
		driver.quit();
	}

}
