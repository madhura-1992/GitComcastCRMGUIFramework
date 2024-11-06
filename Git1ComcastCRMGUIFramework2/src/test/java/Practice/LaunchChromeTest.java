package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchChromeTest {

	@Test(groups = "smokeTest")
	public void launchGoogle() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		System.out.println("Google launched");
		driver.quit();
	}
	
	@Test(groups="regressionTest")
	public void launchAmazon() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		System.out.println("Facebook launched");
		driver.quit();
	}
	
	@Test(groups = "smokeTest")
	public void launchDemoApps() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/");
		System.out.println("DemoApps launched");
		driver.quit();
	}
}
