package practicetest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CliniqueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.clinique.in/");
		driver.findElement(By.xpath("//div[@class=\"gnav-desktop-nav-item\"]/a[contains(text(),'Skincare')]")).click();
		List<WebElement> ele = driver.findElements(By.xpath("//a[contains(text(),'All Skincare')]/parent::div/a"));
		for(WebElement we:ele)
		{
			String data = we.getText();
			System.out.println(data);
		}
	
	}

}
