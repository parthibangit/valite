package userTest;

import org.testng.annotations.Test;

import utility.CommonMethods;

public class VerifyLogin extends CommonMethods
{

	@Test
	public void verifyLogin()
	{
		test=extent.createTest("VerifyLogin").pass("Able to login with valid credentials");
		signIn("globalsuperadmin@valite.org", "password");
		getText();
	}
}
