package utils;

import java.io.IOException;

public class excelUtilsTest {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath = "./data/input.xlsx";
		String sheetName = "Sheet1";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		excel.getRowCount();
		excel.getCellData(1,0);
		
		
	}
}
