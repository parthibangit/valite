package userTest;

import org.testng.annotations.Test;

import utility.CommonMethods;

public class UserCreateVerify extends CommonMethods
{
	
	@Test(priority=0)
	public void createUser() throws Exception
	{
	
		test=extent.createTest("Create User").pass("Able to create user");
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
		test=extent.createTest("delete User").pass("Created user deleted successfully");
		getEmailColumnValues("siam123@test.com");
	}
	
	@Test(priority=2)
	public void userSearch() throws Exception
	{
		test=extent.createTest("user Search").pass("Deleted user not displayed");
		searchUser("siam123@test.com");
	}
	
}
