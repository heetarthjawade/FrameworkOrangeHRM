package orangeHrmTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(testName ="LoginPage", dataProvider = "OrangeHrm")
	public void testLogin(Map<String,String>map) {
		String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String expTextAfterLogin = "Dashboard";
		LoginPage lp = new LoginPage(driver);
		lp.verifyLoginUrl(expUrl);
		lp.verifyLoginHeader("Login");
		lp.login(map.get("username"), map.get("password"));
		lp.verifyDashboardText(expTextAfterLogin);
		
		System.out.println("User logged in successfully");
		
	}
	
	@DataProvider(name = "OrangeHrm")
	public Object[] loginData() throws IOException {
		String fName = System.getProperty("user.dir") +"/src/test/resources/ExcelFiles/OrangeHrm.xlsx";
		FileInputStream fis = new FileInputStream(fName);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("OrangeSheet");
		//int row = sheet.getLastRowNum();
		
		Map<String, String>m1 = new HashMap<>();
		String usernameKey = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(usernameKey);
		String value1      = sheet.getRow(1).getCell(0).getStringCellValue(); 
		System.out.println(value1);
		String passwordKey = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(passwordKey);
		String value2      = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(value2);

		m1.put(usernameKey, value1);
		m1.put(passwordKey, value2);
		return new Object[] {m1};
	}

}
