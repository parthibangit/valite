package initializeClass;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	
	static WebDriver driver;
	
	public static WebDriver getInstance(String browser, String URL)
	{
		
		if(browser.equalsIgnoreCase("chrome"))	
		{
			System.setProperty("webdriver.chrome.driver", "E:\\Parthiban Sys\\selenium files\\browser drivers\\Chrome New\\chromedriver.exe");
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("--headless");
			
			driver=new ChromeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("firefox"))	
		{	
			System.setProperty("webdriver.gecko.driver", "E:\\Parthiban Sys\\selenium files\\browser drivers\\firefox\\geckodriver.exe");
			driver=new FirefoxDriver();
		}	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		return driver;	
	}
	
}
