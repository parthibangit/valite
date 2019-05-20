package utility;

import initializeClass.Initial;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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
		String expectedText= "Quick Link";
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
		
	public void enterValueToemailAndMobile(String email, String mobile)
	{
		userLocator.emailLocator.sendKeys(email);
		userLocator.mobileLocator.sendKeys(mobile);
	}
	
	public void clickSubmit()
	{
		userLocator.saveButtonLocator.click();
	}
}
