package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String excelPath, String sheetNumber) {
		
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetNumber);
			
		} catch (IOException e) {
			System.out.println(e.getCause());
	    	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	public static void getCellData(int rowth,int cellth) throws IOException {
		
		String value = sheet.getRow(rowth).getCell(cellth).getStringCellValue();
		System.out.println(value);
	}
	
	public static void getRowCount() {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("No. of rows:" + rowCount);
		
	    }
	
}
