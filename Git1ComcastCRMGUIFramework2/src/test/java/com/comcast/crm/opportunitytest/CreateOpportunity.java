package com.comcast.crm.opportunitytest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOpportunity {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String orgName = eLib.getDataFromExcel("Opportunity", 1, 0)+jLib.getRandomNumber();
		String oppName = eLib.getDataFromExcel("Opportunity", 1, 1)+jLib.getRandomNumber();
		
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
		driver.findElement(By.name("button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
		WebElement ele = driver.findElement(By.name("potentialname"));
		ele.sendKeys(oppName);
		driver.findElement(RelativeLocator.with(By.tagName("img")).below(ele)).click();
		
		wLib.switchToTabOnURL(driver,"Accounts&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		System.out.println("//a[text()='"+orgName+"']");
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
		wLib.switchToTabOnURL(driver,"Potentials&action");
		
		driver.findElement(By.name("button")).click();	
		
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(oppName))
			System.out.println(oppName+" header information is verified");
		else
			System.out.println(oppName+" header information is not verified");
		
		String actOrgName = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		if(actOrgName.equals(orgName))
			System.out.println(orgName+" information is created");
		else
			System.out.println(orgName+" information is not created");
			
		driver.quit();
	}
}



