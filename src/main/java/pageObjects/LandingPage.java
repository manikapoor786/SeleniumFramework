package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//rahulonlinetutor@gmail.com

public class LandingPage {
	private WebDriver driver;
	
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center>h2");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	
	public LoginPage getLogin()
	{
		 driver.findElement(signin).click();
		 LoginPage lp=new LoginPage(driver);
		 return lp;	 
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(NavBar);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}	
}
