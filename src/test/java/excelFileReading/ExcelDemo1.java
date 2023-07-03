package excelFileReading;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo1 {
	
	@Test
	public void readExcel() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\New_Eclipse_Work\\TestNgProject\\src\\test\\resources\\ExcelFiles\\Data.xlsx");
		
		String sheetName = "PlayerInfo";
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		System.out.println("row : " + row);
		System.out.println("col : " + col);
		
		String val = "";
		for(int r=1;r<=row;r++)
		{
			for(int c=0;c<col;c++)
			{
				val = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.print(String.format("%-12s", val));
			}
			System.out.println();
		
	}

	}}
