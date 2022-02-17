package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesForceLoginpage {
	private WebDriver driver;

	public SalesForceLoginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By username= By.id("username");
	private By password= By.id("password");
	private By login= By.id("Login");
	
	public WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(login);
	}
}
