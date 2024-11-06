package Practice;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class productDetails {

	@DataProvider
	public Object[][] getData1() throws Throwable {
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
