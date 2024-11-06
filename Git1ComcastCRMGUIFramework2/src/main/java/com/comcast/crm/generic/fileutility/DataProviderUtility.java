package com.comcast.crm.generic.fileutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider
	public Object[][] getData1() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowCount("novels");
		
		Object[][] objArr=new Object[rowCount][2];
		System.out.println("Getting data from generic");
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("novels", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("novels", i+1, 1);
		}
		return objArr;
	}
}
