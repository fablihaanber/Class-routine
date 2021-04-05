package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Teacher{
	String teacherInitial;
	String[] courses;
	String[] freeTime;
	
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
	   
	    for(int i=1;i<rowNumber+1;i++) { 
		    int noOfCell = excel1.getNumberOfCell(i-1);
		    String[] courses;
		    courses = new String[noOfCell];
		    for(int j=1;j<noOfCell+1;j++) {
	  
			    String excelCourse;
			    excelCourse = excel1.getCellData(i, j);
			    if(!excelCourse.equals("")) {
			    	courses[j-1] = excelCourse;
			    	 
		     } 
		  }
		  List<String>nonNullCourses = new ArrayList<String>();
		  for(String course: courses) {
			  if(course!=null) {
				  nonNullCourses.add(course);
			  }
		  }
		  String [] beautifiedCourses = nonNullCourses.toArray(new String[nonNullCourses.size()]);                
		  teacher[i-1].courses = new String[beautifiedCourses.length] ;
		  teacher[i-1].courses = beautifiedCourses;
	  }
		  
	    
	    ExcelUtils excel2 = new ExcelUtils(excelPath, sheet3);
	    for(int i=1;i<rowNumber+1;i++) { 
		    int noOfCell = excel2.getNumberOfCell(i-1);
		    String[] freeTimes;
		    freeTimes = new String[noOfCell];
		    for(int j=1;j<noOfCell+1;j++) {
	  
			    String excelFreeTime;
			    excelFreeTime = excel2.getCellData(i, j);
			    if(!excelFreeTime.equals("")) {
			    	freeTimes[j-1] = excelFreeTime;
			    	 
		     } 
		  }
		  List<String>nonNullFreeTime = new ArrayList<String>();
		  for(String freeTime: freeTimes) {
			  if(freeTime!=null) {
				  nonNullFreeTime.add(freeTime);
			  }
		  }
		  String [] beautifiedFreeTime = nonNullFreeTime.toArray(new String[nonNullFreeTime.size()]);                
		  teacher[i-1].freeTime = new String[beautifiedFreeTime.length] ;
		  teacher[i-1].freeTime = beautifiedFreeTime;
	  }
	    for(int i=0;i<rowNumber;i++) {
	    	System.out.println(Arrays.toString(teacher[i].courses));
	    	
	    	System.out.println(teacher[i].teacherInitial);
	    	System.out.println(Arrays.toString(teacher[i].freeTime));
		      
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