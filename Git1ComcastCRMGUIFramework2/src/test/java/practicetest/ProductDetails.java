package practicetest;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class ProductDetails {

	@DataProvider(name="details")
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowCount("novels");
		
		Object[][] objArr=new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++)
		{
			objArr[i][0]=eLib.getDataFromExcel("novels", i+1, 0);
			objArr[i][1]=eLib.getDataFromExcel("novels", i+1, 1);
		}
		return objArr;
	}
}
