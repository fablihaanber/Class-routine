package utils;

import java.io.IOException;
import java.util.Arrays;

class Teacher{
	String teacherInitial;
	String[] courses;
	String[][] freeTime;
	
	Teacher(String teacherInitial){
		this.teacherInitial = teacherInitial;
	}
}

public class excelUtilsTest {
	
	public static void main(String[] args) throws IOException {
		
		String excelPath = "./data/inputExcelExcel.xlsx";
		String sheet1 = "Sheet1";
		String sheet2 = "Sheet2";
		String sheet3 = "Sheet3";
		ExcelUtils excel = new ExcelUtils(excelPath, sheet1);
		//ExcelUtils excel2 = new ExcelUtils(excelPath, sheet2);
		//ExcelUtils excel3 = new ExcelUtils(excelPath, sheet3);
		int rowNumber = excel.getRowCount()-1;
		int numberOfCourses = excel.getNumberOfCell(2)-1;
		
	
		 
		Teacher[] teacher = new Teacher[rowNumber];
		
	    for(int i=0;i<rowNumber;i++) {
	      String teacherInitials = excel.getCellData(i+1, 0);
		  teacher[i] = new Teacher(teacherInitials);
	    }
	    
	    ExcelUtils excel1 = new ExcelUtils(excelPath, sheet2);
	    int[] arr = new int[2];
		int teacherCourseCount = 0;
		int teacherCount = 0;
		
		
	    for(int i=1;i<rowNumber;i++) { 
		    int noOfCell = excel1.getNumberOfCell(i-1);
		    arr[i] = noOfCell;
		    String[] courses;
		    courses = new String[noOfCell];
		    for(int j=1;j<noOfCell;j++) {
	  
			    String wow;
			    wow = excel1.getCellData(i, j);
			    if(!wow.equals("")) {
			    	courses[j-1] = wow;
			    	 
		     } 
		  }
		  System.out.println(Arrays.toString(courses));
	  }
		  
	    for(int i=0;i<rowNumber;i++) {
	    	System.out.println(teacher[i].courses);
	    	
	    	System.out.println(teacher[i].teacherInitial);
	    	
		      
		    }

	    
	    for(int i=0;i<rowNumber;i++) {
	    	String[] teacherCourses;
	    	
		      
		    }
	    for(int i=0;i<rowNumber;i++) {
	    	String[][] freeTime;
		      
		    }
	    
	    
		 
		//System.out.println(rowNumber);
		
		
		
	}
}