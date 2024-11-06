package com.comcast.crm.troubletickettest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateTroubleTicket {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String title = eLib.getDataFromExcel("TroubleTicket", 1, 0)+jLib.getRandomNumber();
		String lastName = eLib.getDataFromExcel("TroubleTicket", 1, 1)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
		
		driver.manage().window().maximize();
		
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("button")).click();
		
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Trouble Tickets']")).click();
		driver.findElement(By.xpath("//img[@title='Create Ticket...']")).click();
		driver.findElement(By.name("ticket_title")).sendKeys(title);
		driver.findElement(By.xpath("//input[@id='parentid']/following-sibling::img")).click();
		
		wLib.switchToTabOnURL(driver,"Contacts&action");
		
		driver.findElement(By.id("search_txt")).sendKeys(lastName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()=' "+lastName+"']")).click();
	
		wLib.switchToTabOnURL(driver,"HelpDesk&action");
		
		driver.findElement(By.name("button")).click();
		
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(title))
			System.out.println("trouble ticket is raised successfully");
		else
			System.out.println("trouble ticket is not raised");
		
		String actContact = driver.findElement(By.xpath("//td[@class='dvtCellInfo']//a[text()=' "+lastName+"']")).getText();
		if(actContact.equals(lastName))
			System.out.println(lastName+" information is successfully created");
		else
			System.out.println(lastName+" information is not created");
		
		driver.quit();
	}

}
