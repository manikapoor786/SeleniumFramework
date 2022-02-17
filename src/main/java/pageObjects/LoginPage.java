package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By email=By.cssSelector("[id='user_email']");
	private By password=By.cssSelector("[type='password']");
	private By login=By.cssSelector("[value='Log In']");
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
}
