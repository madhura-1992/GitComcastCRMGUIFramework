package com.comcast.crm.producttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateProductWithPOM {

	public static void main(String[] args) throws Throwable {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String BROWSER = fLib.getDataFromPropertiesFile("Browser");
		String URL = fLib.getDataFromPropertiesFile("Url");
		String USERNAME = fLib.getDataFromPropertiesFile("Username");
		String PASSWORD = fLib.getDataFromPropertiesFile("Password");
		
		String product = eLib.getDataFromExcel("Products", 1, 0)+jLib.getRandomNumber();
				
		WebDriver driver = wLib.launchBrowser("BROWSER");
		
		wLib.waitForPageToLoad(driver);
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
				
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductBtn().click();
		
		CreatingNewProductPage cnpp=new CreatingNewProductPage(driver);
		cnpp.createProduct(product);
				
		ProductInformationPage pip=new ProductInformationPage(driver);
		String actproductname = pip.getActProductName().getText();
		
		if(product.equals(actproductname))
			System.out.println(product+" is added");
		else
			System.out.println(product+" is not added");
		
		hp.logout();
		
		driver.quit();
	}

}
