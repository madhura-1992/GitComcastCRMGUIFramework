package com.comcast.crm.generic.assertutility;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertUtility {

	public void hardAssertEquals(String actText,String expText) {
		 Assert.assertEquals(actText, expText);
	}
	
	public void hardAssertContains(String actText,String expText) {
		boolean res=actText.contains(expText);
		 Assert.assertTrue(res);
	}
	
	SoftAssert sassert=new SoftAssert();
	
	public void softAssertEquals(String actText,String expText) {
		sassert.assertEquals(actText, expText);
		sassert.assertAll();
	}
	
	public void softAssertContains(String actText,String expText) {
		boolean res=actText.contains(expText);
		sassert.assertTrue(res);
		sassert.assertAll();
	}
}
