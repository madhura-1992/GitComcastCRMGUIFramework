package practicetest;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author Madhura
 */
public class searchContactTest extends BaseClass{
	/**
	 * Scenario: login==>navigateToContact==>createContact==>verify
	 */
	@Test
public void searchcontacttest() {
		/*step-1: login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("url", "username", "password");
	}
}
