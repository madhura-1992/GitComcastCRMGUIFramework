package Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;


public class ActivateSimTest extends BaseClass {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementation.class)
	public void activateSim()
	{
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		SoftAssert sassert=new SoftAssert();
		sassert.assertEquals(actTitle, "Login");
		sassert.assertAll();
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
