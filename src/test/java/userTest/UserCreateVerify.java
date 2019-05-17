package userTest;

import org.testng.annotations.Test;

import utility.CommonMethods;

public class UserCreateVerify extends CommonMethods
{
	
	@Test(priority=0)
	public void createUser() throws Exception
	{
	
		test=extent.createTest("UserCreateVerify").pass("Able to ceate user");
		signIn("globalsuperadmin@valite.org", "password");
		navigateToUser();
		selectRoleAndPerson();
		enterTextToNames("Siam", "Test");
		enterValueToemailAndMobile("siam@test.com", "7200412631");
		clickSubmit();
	}
	
}
