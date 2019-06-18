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
		clickAdd(userLocator.addUserLocator);
		selectRoleAndPerson();
		enterTextToNames("Siam", "Test");
		enterValueToemailAndMobile("siam123@test.com", "7200412631");
		clickSubmit();
		System.out.println("User created");
	}
	
	@Test(priority=1)
	public void deleteUser() throws Exception
	{
		test=extent.createTest("deleteUser").pass("Able to view the added user");
		getEmailColumnValues("siam123@test.com");
	}
	
	@Test(priority=2)
	public void userSearch() throws Exception
	{
		test=extent.createTest("usersearch").pass("Able to view the added user");
		searchUser("siam123@test.com");
	}
	
}
