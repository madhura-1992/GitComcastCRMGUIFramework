package practicetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.DataProviderUtility;

public class GetProductInfoTest {

	@Test(dataProviderClass = DataProviderUtility.class,dataProvider ="getData1")
	public void getProductInfoTest(String language, String name)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		//search for product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(language,Keys.ENTER);
		//capture product info
		WebElement ele=driver.findElement(By.xpath("//span[text()=\""+name+"\"]/../../../../div[3]/div[1]/div/div[1]/div[3]/div[1]/a/span/span[2]/span[2]"));
		String price=ele.getText();
		System.out.println(price);
		
		driver.quit();
	}
	
	/*@DataProvider(name="details")
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
	}*/
}
