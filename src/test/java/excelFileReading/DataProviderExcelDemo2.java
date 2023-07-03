package excelFileReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcelDemo2 {
	@Test(dataProvider = "DP2")
	public void verifyLogin(Map<String, String>map) {
		System.out.println(map.get("username")+ map.get("password"));
	}

	@DataProvider(name  = "DP2")
	public Object[] getData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\New_Eclipse_Work\\TestNgProject\\src\\test\\resources\\ExcelFiles\\Credentials.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Credentials");
		int row = sheet.getLastRowNum();
		Object[] data = new Object[row];
		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();
		Map<String, String>m1;
		for(int r=0; r<row;r++) {
			m1 = new HashMap<>();
			String value1 = sheet.getRow(r+1).getCell(0).getStringCellValue();
			String value2 = sheet.getRow(r+1).getCell(1).getStringCellValue();
			m1.put(header1, value1);
			m1.put(header2, value2);
			data[r] = m1;
		}
		
		return data;
	}
}
