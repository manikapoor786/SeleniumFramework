package Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PracticeTest {

	@Test
	public void tabmethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		Actions a= new Actions(driver);
		Thread.sleep(20);
		a.moveToElement(driver.findElement(By.xpath("//a[@id=\"opentab\"]"))).click();
	}
	
}
