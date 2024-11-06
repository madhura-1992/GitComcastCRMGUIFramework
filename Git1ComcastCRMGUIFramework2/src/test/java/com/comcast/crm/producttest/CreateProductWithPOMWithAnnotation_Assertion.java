package com.comcast.crm.producttest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.ProductInformationPage;
import com.comcast.crm.objectrepositoryutility.ProductsPage;

public class CreateProductWithPOMWithAnnotation_Assertion extends BaseClass{

	@Test(groups="smokeTest")
	public void createProductTest() throws Throwable {
		
		String product = eLib.getDataFromExcel("Products", 1, 0)+jLib.getRandomNumber();
				
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.getCreateProductBtn().click();
		
		CreatingNewProductPage cnpp=new CreatingNewProductPage(driver);
		cnpp.createProduct(product);
				
		ProductInformationPage pip=new ProductInformationPage(driver);
		String actproductname = pip.getActProductName().getText();
		au.hardAssertEquals(actproductname, product);
	}
}
