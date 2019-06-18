package pagesAdmin;

import java.util.List;

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
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Users')]")
	public WebElement userMenuLocator;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Add User')]")
	public WebElement addUserLocator;
	
	@FindBy(how=How.XPATH, using="//select[@title='Role is required']")
	public WebElement roleListLocator;
	
	@FindBy(how=How.XPATH, using="//select[@class='form-control text-capitalize' and @xpath=1]")
	public WebElement reportPersonLocator;
	
	@FindBy(how=How.NAME, using="first_name")
	public WebElement firstNameLocator;
	
	@FindBy(how=How.XPATH, using="(//input[@type='text'])[last()-1]")
	public WebElement lastNameLocator;
	
	@FindBy(how=How.XPATH, using="(//input[@type='text'])[last()]")
	public WebElement emailLocator;
	
	@FindBy(how=How.XPATH, using="//input[@type='number']")
	public WebElement mobileLocator;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'Save')]")
	public WebElement saveButtonLocator;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(), 'Cancel')]")
	public WebElement cancelBbuttonLocator;
	
	@FindBy(how=How.XPATH, using="//input[@type='text']")
	public WebElement searchBoxLocator;
	
	@FindBy(how=How.XPATH, using="//td[6]")
	public List<WebElement> emailColumnLocator;
	
	@FindBy(how=How.XPATH, using="//td")
	public WebElement afterDeleteEmailLocator;
	
	@FindBy(how=How.XPATH, using="//button[@title='Delete']")
	public List<WebElement> deleteUserLocator;
	
	@FindBy(how=How.XPATH, using="(//button[@type='button'])[last()]")
	public WebElement confirmLocator;
	
}
