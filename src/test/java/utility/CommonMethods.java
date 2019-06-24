package utility;

import initializeClass.Initial;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CommonMethods extends Initial
{
	
	
	// This methods is for signin
	public void signIn(String uName, String pwd)
	{
		loginLocators.userName_locator.sendKeys(uName);
		loginLocators.pwd_locator.sendKeys(pwd);
		loginLocators.submit_locator.click();
	}
	
	
	//This method is for get the dashboard text after login
	public void getText()
	{
		String actualText=loginLocators.dashBoard_locator.getText();
		String expectedText= "Quick Links";
		System.out.println("Actutal text is: "+actualText);
		System.out.println("Expected text is: "+expectedText);
		Assert.assertEquals(actualText, expectedText, "Text not matched - Test failed");
		
	}
	
	public void navigateToUser() throws Exception
	{
		//Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(globalDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(userLocator.userMenuLocator)).click();
		
	}
	
	public void clickAdd(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(globalDriver, 10);
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
	
	public void selectRoleAndPerson() throws Exception
	{
		Thread.sleep(3000);
		Select roleDrop=new Select(userLocator.roleListLocator);
		roleDrop.selectByVisibleText("Content head");
		
//		Thread.sleep(3000);
//		Select personDrop=new Select(userLocator.reportPersonLocator);
//		personDrop.selectByVisibleText("test admin (Super admin)");
	}
	
	public void enterTextToNames(String firstName, String lastName)
	{
	    userLocator.firstNameLocator.sendKeys(firstName);
	    userLocator.lastNameLocator.sendKeys(lastName);
	}
	
	// This method is used to enter the details into email and mobile fields
	public void enterValueToemailAndMobile(String email, String mobile)
	{
		userLocator.emailLocator.sendKeys(email);
		userLocator.mobileLocator.sendKeys(mobile);
	}
	
	// This method is for click the submit button
	public void clickSubmit()
	{
		userLocator.saveButtonLocator.click();
	}
	
	@DataProvider(name="logindata")
	public Object[] userData()
	{
		return new Object[][]
		{
				{"globalsuperadmin@valite.org", "password"},	
				{"parthiban@siamcomputing.com", "password"},
				{"sarathipartha04@gmail.com", "password"}			
		};
		
	}
	
	
	public void logout() throws Exception
	{
		Thread.sleep(3000);
		WebDriverWait wait=new WebDriverWait(globalDriver, 10);
		Actions act=new Actions(globalDriver);
		act.moveToElement(userLocator.logoutMenuLocator).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(userLocator.logoutLocator)).click();
	}
	
	public void getEmailColumnValues(String email) throws Exception
	{
		Thread.sleep(3000);
		List<String> list=new ArrayList<String>();
		for(int i=0; i<userLocator.emailColumnLocator.size(); i++)
		{
			WebElement element=userLocator.emailColumnLocator.get(i);
			list.add(element.getText());
			
			int index=list.indexOf(email);
			
			if(list.contains(email))
			{
				System.out.println("User added in list");
				
				for(int j=index; j<userLocator.deleteUserLocator.size(); j++)
				{
					WebElement element1=userLocator.deleteUserLocator.get(index);
					if(element1 != null)
					{
					   element1.click();
					   Thread.sleep(2000);
					   userLocator.confirmLocator.click();
					   break;
					}
				}
				
				break;
			}
				
		}
	}		
	
	public void searchUser(String email) throws Exception
	{
	
		  Thread.sleep(2000);
		  userLocator.searchBoxLocator.sendKeys(email);
		  
		  String actual_text=userLocator.afterDeleteEmailLocator.getText();
		  String Expected_text="There is no data to display";
		  
		  Assert.assertEquals(actual_text, Expected_text, "Text not displayed - Test case failed");
		  System.out.println("Deleted user not displayed");
			  
	}
	
}
