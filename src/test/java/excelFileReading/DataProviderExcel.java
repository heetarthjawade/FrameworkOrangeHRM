package excelFileReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExcel {
	@Test(dataProvider = "DP")
	public void verifyLogin(Map<String, String>map) {
		System.out.println(map.get("username")+ map.get("password"));
	}
	
	@DataProvider(name = "DP")
	public Object[] getData() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\New_Eclipse_Work\\TestNgProject\\src\\test\\resources\\ExcelFiles\\Credentials.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Credentials");
		
		Object[] data = new Object [2];
		String header1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String header2 = sheet.getRow(0).getCell(1).getStringCellValue();
		
		Map<String,String>m1 = new HashMap<>();
		String value1 = sheet.getRow(1).getCell(0).getStringCellValue();
		String value2 = sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(header1+" "+value1);
		System.out.println(header2+" "+value2);
		m1.put(header1, value1);
		m1.put(header2, value2);
		data[0] = m1;
		
		Map<String,String>m2 = new HashMap<>();
		value1 = sheet.getRow(2).getCell(0).getStringCellValue();
	    value2 = sheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(header1+" "+value1);
		System.out.println(header2+" "+value2);
		m2.put(header1, value1);
		m2.put(header2, value2);
		data[1] = m2;
		return data;
		
	}

}
