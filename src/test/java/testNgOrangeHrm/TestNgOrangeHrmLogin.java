package testNgOrangeHrm;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgOrangeHrmLogin {
	private final By un	 		 = By.name("username");
	private final By pd 		 = By.name("password");
	private final By login 		 = By.xpath("//button[@type='submit']");
	private final By errorMsg	 = By.xpath("//div[@role='alert']//p");
	String expErrorMsg			 = "Invalid credentials123";
	Properties prop;
	WebDriver driver;
	
	private void readOrangeHrmPropFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\New_Eclipse_Work\\TestNgProject\\src\\test\\resources\\OrangeHrmCred.properties");
		prop.load(fis);
	}
	
	private WebElement getWebElement(By by) {
		return driver.findElement(by);
	}
	
	private void type(By by, String data) {
		getWebElement(by).sendKeys(data);
	}
	
	private void click(By by) {
		getWebElement(by).click();
	}
	
	private void inputFields(String username, String password) {
		type(un, username);
		type(pd, password);
		click(login);
	}
	
	private String getTextMethod() {
		return getWebElement(errorMsg).getText();
	}
	
	private void launchBrowser() throws IOException {
		readOrangeHrmPropFile();
		 String browser = prop.getProperty("browser");
		 switch(browser.toUpperCase()) {
		 case "CHROME":
			 driver = new ChromeDriver();
			 break;
			 
		 case "EDGE":
			 driver = new EdgeDriver();
			 break;
			 
			 default:
				 throw new RuntimeException("Invalid Browser: "+ browser);
		 }
		 
		driver.get(prop.getProperty("url"));
		if(Boolean.parseBoolean(prop.getProperty("maxWindow"))== true) {
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
	}
		
	@Test(dataProvider="BCCI")
	public void validateLogin(String username, String password) {
		inputFields(username, password);
		Assert.assertEquals(expErrorMsg, getTextMethod(), "LoginFailed");
	}
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		launchBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "BCCI")
	public Object[][] getData() {
		Object[][] data =  {{"Harbhajan", "Bhajji123"},
							{"Virat", "Virat123"},
							{"Rohit", "VadaPav123"},
							{"Saurabh", "Dada143"}
							};
		return data;
	}
	
 
}
