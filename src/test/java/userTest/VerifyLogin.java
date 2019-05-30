package userTest;

import org.testng.annotations.Test;

import utility.CommonMethods;

public class VerifyLogin extends CommonMethods
{

	@Test(priority=0, dataProvider="logindata", dataProviderClass=CommonMethods.class)
	public void verifyLogin(String username, String password) throws Exception
	{
		test=extent.createTest("VerifyLogin");
		signIn(username, password);
		getText();
		logout();
		
	}	
}
