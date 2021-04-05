package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	ExcelUtils(String excelPath, String sheetNumber) {
		
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetNumber);
			
		} catch (IOException e) {
			System.out.println(e.getCause());
	    	System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	public static String getCellData(int rowth,int cellth) throws IOException {
		String value;
		Cell cell = sheet.getRow(rowth).getCell(cellth);
		if(cell==null)value = "";
		else value = cell.getStringCellValue();
		
		return value;
	}
	
	public static int getRowCount() {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		return rowCount;
		
	    }
	public static int getNumberOfCell(int rowth) throws IOException {
			
			int cellCount = sheet.getRow(rowth).getPhysicalNumberOfCells();
			return cellCount;
		}
	
}