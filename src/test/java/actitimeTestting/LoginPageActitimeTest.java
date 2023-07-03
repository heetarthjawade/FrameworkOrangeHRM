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

//import actitimePOM.page.LoginPageActitime;

public class LoginPageActitimeTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1/login.do;jsessionid=7sfckuotdqrcu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(testName = "verifyLoginPage", dataProvider = "testData")
	public void loginTest1(Map<String, String> map) {
		String expUrl = "http://127.0.0.1/user/submit_tt.do";
		//String expMsg = "Username or Password is invalid. Please try again.";
		LoginPageActitime loginPage = new LoginPageActitime(driver);
		loginPage.verifyLoginFunctionality(map.get("username"), map.get("password"));
		//loginPage.verifyLoginMsg(expMsg);
		loginPage.verifyActualUrl(expUrl);
	}

	@DataProvider(name = "testData")
	public Object[] getData() throws IOException {
		String fName = System.getProperty("user.dir") + "/src/test/resources/ExcelFiles/testData.xlsx";
		FileInputStream fis = new FileInputStream(fName);
		String sheetName = "loginData";
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum();

		Object[] obj = new Object[row];
		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();
		Map<String, String> m1;
		for (int r = 0; r < row; r++) {
			m1 = new HashMap<>();
			String value1 = sheet.getRow(r + 1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r + 1).getCell(1).getStringCellValue();
			m1.put(header1, value1);
			m1.put(header2, value2);

			obj[r] = m1;
		}

		return obj;

	}
}
