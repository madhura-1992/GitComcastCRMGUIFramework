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

public class CreateContactWithOrg {

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
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		wLib.switchToTabOnURL(driver,"Accounts&action");
	
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
		wLib.switchToTabOnURL(driver,"Contacts&action");
		
		driver.findElement(By.name("button")).click();
		
		String Headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Headerinfo.contains(lastName)) {
			System.out.println(lastName+" header is verified==PASS");
		}else {
			System.out.println(lastName+" header is not verified==FAIL");
		}
		
		String actOrgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actOrgname);
		System.out.println(orgName);
		if(actOrgname.trim().equals(orgName))
		{
			System.out.println(orgName+" information is created");
		}else {
			System.out.println(orgName+" information is not created");
		}
		driver.quit();
		
	}

}
