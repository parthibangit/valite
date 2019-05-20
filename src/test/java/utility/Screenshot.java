package utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	
	public static String takeScreenshot(WebDriver driver, String name) throws Exception
	{
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File source=tc.getScreenshotAs(OutputType.FILE);
		String destination="C:\\Users\\user\\workspace\\com.valite.selenium\\Screenshots\\" +name+".png";
		File dest=new File(destination);
		FileHandler.copy(source, dest);	
		return destination;
	}	
}
