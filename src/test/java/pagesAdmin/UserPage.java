package pagesAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserPage 
{
	
	WebDriver driver;
	
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//button[@type='button']//i[@class='fa fa-user']")
	public WebElement logoutMenuLocator;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'Logout')]")
	public WebElement logoutLocator;
	
	@FindBy(how=How.ID, using="//span[@class='MuiTypography-root-152 MuiTypography-subheading-159 MuiListItemText-primary-149'][contains(text(),'Users')]")
	public WebElement userMenuLocator;;
	
	@FindBy(how=How.ID, using="//select[@title='Role is required']")
	public WebElement roleListLocator;
	
	@FindBy(how=How.ID, using="//select[@class='form-control text-capitalize']//option[@value='nodata']")
	public WebElement reportPersonLocator;
	
	@FindBy(how=How.NAME, using="first_name")
	public WebElement firstNameLocator;
	
	@FindBy(how=How.NAME, using="//input[@type='text'][@xpath='1']")
	public WebElement lastNameLocator;
	
	@FindBy(how=How.NAME, using="//div[3]//div[1]//div[1]//div[3]//div[1]//div[1]//input[1]")
	public WebElement emailLocator;
	
	@FindBy(how=How.NAME, using="//input[@type='number']")
	public WebElement mobileLocator;
	
	@FindBy(how=How.ID, using="//span[contains(text(), 'Save')]")
	public WebElement saveButtonLocator;
	
	@FindBy(how=How.ID, using="//span[contains(text(), 'Cancel')]")
	public WebElement cancelBbuttonLocator;
	
}
