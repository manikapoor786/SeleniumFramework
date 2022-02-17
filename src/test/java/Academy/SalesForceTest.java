package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.SalesForceLoginpage;
import resources.base;

public class SalesForceTest extends base {

		public WebDriver driver;
		public static Logger log =LogManager.getLogger(base.class.getName());
		 
		@BeforeTest
		public void initialize() throws IOException
		{
			 driver =initializeDriver();	
			 driver.get("https://login.salesforce.com/");
		}
		
		@Test
		public void validateAppNavBar() throws IOException
		{
			SalesForceLoginpage sl=new SalesForceLoginpage(driver);
		    sl.getUsername().sendKeys(getExcelData().get(0));
		    sl.getPassword().sendKeys(getExcelData().get(1));
		    sl.Login().click();
		}
		
		@AfterTest
		public void teardown()
		{
			driver.close();	
		}
	}
