package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public WebDriver driver=null;
	public WebDriver launchBrowser(String BROWSER)
	{
		if(BROWSER.equals("chrome")) {
			//System.out.println("if");
			driver=new ChromeDriver();
		} else if(BROWSER.equals("edge")) {
			//System.out.println("else if1");
			driver=new EdgeDriver();
		} else if(BROWSER.equals("firefox")) {
			//System.out.println("else if2");
			driver=new FirefoxDriver();
		} else {
			//System.out.println("else");
			driver=new ChromeDriver();
		}
		//System.out.println("Hi"+driver);
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void minimizeBrowser(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver,String partialURL)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL))
				break;
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver,String partialTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext())
		{
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getTitle();
			if(actUrl.contains(partialTitle))
				break;
		}
	}
	
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	public void navigateRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToDefaultWindow(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchToParentWindow(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void select(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByValue(text);
	}
	
	public void mouseMoveOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void clickAndHoldOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void dragAndDropAnElement(WebDriver driver,WebElement element1,WebElement element2)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(element1,element2).perform();
	}
	
	public void contextClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void scrollByAmountOnBrowser(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.scrollByAmount(x,y).perform();
	}
	
	public void scrollToElementOnBrowser(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void screenshotOfBrowser(WebDriver driver) throws IOException
	{
		Date d=new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":","-");
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst=new File("./browserscreenshot/"+d2+".jpeg");
		FileHandler.copy(src,dst);
	}
	
	public void screenshotOfElement(WebElement element) throws IOException
	{
		Date d=new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":","-");
		File src = element.getScreenshotAs(OutputType.FILE);
		File dst=new File("./elementscreenshot/"+d2+".jpeg");
		FileHandler.copy(src,dst);
	}
	
	
	
}
