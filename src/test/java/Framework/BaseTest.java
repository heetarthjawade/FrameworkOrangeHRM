package Framework;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cs.Driver.Driver;
import com.cs.ReadProperties.ReadProperties;

public class BaseTest {
	static Properties prop=null;
	
	@BeforeSuite
	public static void loadPropertyFile()  
	{
		prop = ReadProperties.readPropertyFile();
	}
	
	@BeforeMethod
	public static void tearUp()
	{
		Driver.initDriver();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitBrowser();
	}
}
