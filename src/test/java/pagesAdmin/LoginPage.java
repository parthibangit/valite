package pagesAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(how=How.NAME, using="email_id")
	public WebElement userName_locator;
	
	@FindBy(how=How.NAME, using="password")
	public WebElement pwd_locator;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	public WebElement submit_locator;

	@FindBy(how=How.XPATH, using="//h4[contains(text(), 'Quick Links')]")
	public WebElement dashBoard_locator;
	
	
}
