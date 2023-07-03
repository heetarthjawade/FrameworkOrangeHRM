package actitimeTestting;

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

public class TestVerificationOfActitime {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(testName="loginTest", dataProvider ="testData" )
	public void loginTest1(Map<String, String> map) {
		String expUrl = "https://demo.actitime.com/login.do";
		String expErrorMsg = "Username or Password is invalid. Please try again.";
		VerifyingActitimeLogin verify = new VerifyingActitimeLogin(driver);
		verify.verifyingLoginFunt(map.get("username"), map.get("password"));
		verify.verfyingActUrl(expUrl);
		System.out.println("Act url iss "+verify.getActUrl());
		verify.verifyingErrorMsg(expErrorMsg);
		
		
	}
	
	@DataProvider(name = "testData")
	public Object getData() throws IOException {
		String fName = System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/testData.xlsx";
		FileInputStream fis = new FileInputStream(fName);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("loginData");
		int row = sheet.getLastRowNum();
		
		Object[] obj = new Object[row];
		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();
		Map<String, String> m1;
		for(int r=0;r<row;r++) {
			m1 = new HashMap<>();
			String value1 = sheet.getRow(r+1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r+1).getCell(1).getStringCellValue();
			m1.put(header1, value1);
			m1.put(header2, value2);
			
			obj[r] = m1;
		}
		return obj;
		
		
		
	}

}
