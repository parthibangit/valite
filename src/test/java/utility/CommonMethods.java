package utility;

import initializeClass.Initial;

import org.openqa.selenium.By;
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
		Thread.sleep(3000);
		userLocator.userMenuLocator.click();
		
	}
	
	public void selectRoleAndPerson()
	{
		Select roleDrop=new Select(userLocator.roleListLocator);
		roleDrop.selectByVisibleText("Learning content expert");
		
		Select personDrop=new Select(userLocator.reportPersonLocator);
		personDrop.selectByVisibleText("Parthiban Subburam (Content head)");
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
		
}
