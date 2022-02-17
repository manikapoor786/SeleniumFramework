package resources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class base {
	private WebDriver driver;
	private Properties prop;
	private FileInputStream fis;
	DesiredCapabilities dc;
	ChromeOptions options;
	String testname="";
	ArrayList<String> al= new ArrayList<String>();
	DataDrivenExcelMapping2 ddem= new DataDrivenExcelMapping2();
	
	public ArrayList<String> getExcelData() throws IOException
	{
		al=ddem.getExcelData("Login");
		return al;
	}
	
	public Properties getProperties()
	{
		return prop;
	}
	
	public void setMethodname(String testcase)
	{
		this.testname=testcase;
		System.out.println(testname);
	}
	
	public String getMethodname(WebDriver driver)
	{
		System.out.println(testname);
		return testname;
	}
	
	public WebDriver initializeDriver() throws IOException
	{
		
		prop= new Properties();
		fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		String host="localhost";
		dc= new DesiredCapabilities();
		dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		dc.setPlatform(Platform.WINDOWS);
		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver\\chromedriver.exe");
			options= new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");	
			}
			
			//driver=new ChromeDriver(options);
			if(prop.getProperty("HUB_HOST")!=null) 
			{
				host=prop.getProperty("HUB_HOST");
			}
			
			String completeUrl= "http://" +host+ ":4444/wd/hub";
			options.setCapability("name", getMethodname(driver));
			System.out.println(getMethodname(driver));
			driver= new RemoteWebDriver(new URL(completeUrl), dc);
			
		}
		//mvn test -Dbrowser=chrome(or chromeheadless if want to run headless)  --run via cmd
		else if(browserName.equals("firefox"))
		{	
		}
		
		else
		{
		}
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;		
	}
	
	
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}	
}
