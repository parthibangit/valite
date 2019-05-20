package initializeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pagesAdmin.LoginPage;
import pagesAdmin.UserPage;
import utility.Screenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Initial 
{
	
	public LoginPage loginLocators;
	public UserPage userLocator;
	public WebDriver globalDriver;
	public ExtentReports extent;
	public ExtentTest test;
	//String path="./screenshots/ +";
	
	@BeforeSuite
	public void reportSetUp()
	{
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./Test Report/extentReports.html");
		//htmlReporter.setAppendExisting(true);
		htmlReporter.config().setDocumentTitle("Automation report");
		htmlReporter.config().setReportName("Functional Test");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	
	@BeforeTest(alwaysRun=true)
	public void initialization()
	{
		globalDriver=BrowserFactory.getInstance("chrome", "http://dev.valite.org");
	    loginLocators=PageFactory.initElements(globalDriver, LoginPage.class);
	    userLocator=PageFactory.initElements(globalDriver, UserPage.class);
	}
	
	@BeforeMethod
	public void beforePrint()
	{
		System.out.println("==========Test Execution started==========");
	}
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception
	{
		System.out.println("==========Test Execution finished==========");
		
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.pass(MarkupHelper.createLabel(result.getName() +" Test case passed", ExtentColor.GREEN));
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName() +" Test case Failed", ExtentColor.RED));
		    Screenshot.takeScreenshot(globalDriver, result.getName());
			test.fail(result.getThrowable());
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.skip(MarkupHelper.createLabel(result.getName() +" Test case Skipped", ExtentColor.YELLOW));
		}
			
	}
	
	@AfterTest
	public void tearDown()
	{
		globalDriver.close();
	}
	
	@AfterSuite
	public void extentClose()
	{
		extent.flush();
	}
}
