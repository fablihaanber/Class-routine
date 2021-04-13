package utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Teacher{
	String teacherInitial;
	String[] courses;
	String[] freeTime;
	String[][] freeTimeArray;
	int noOfDays = 7;
	int[][] isFree;
	int[][] visitedisFree;

	Teacher(String teacherInitial){
		this.teacherInitial = teacherInitial;
	}

	public String[][] freetime() {
		freeTimeArray = new String[noOfDays][];
		for(int i=0;i<noOfDays;i++) {
			String[] str = freeTime[i].split(";");
			freeTimeArray[i] = new String[str.length];
			System.arraycopy(str, 0, freeTimeArray[i], 0, str.length);
		}
		return freeTimeArray;

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
		int noOfDays = 7;
		
		for(int i=0;i<rowNumber;i++) {
			String teacherInitials = excel.getCellData(i+1, 0);
			teacher[i] = new Teacher(teacherInitials);
		}

		//Storing the subjects of teachers from excel file
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

			String [] beautifiedCourses = removeNullValues(courses);                
			teacher[i-1].courses = new String[beautifiedCourses.length] ;
			teacher[i-1].courses = beautifiedCourses;
			// System.out.println(Arrays.toString(teacher[i-1].courses));
		}

		//Storing the free times of teachers from excel file
		ExcelUtils excel2 = new ExcelUtils(excelPath, sheet3);
		int totalCoursesCount = 0;
		for(int i=1;i<rowNumber+1;i++) { 
			
			String[] freeTimes;
			freeTimes = new String[noOfDays];
			for(int j=1;j<=noOfDays;j++) {
				//		    	System.out.println(excel2.getCellData(i, j));
				String excelFreeTime;
				excelFreeTime = excel2.getCellData(i, j);
				if(!excelFreeTime.equals("")) {
					freeTimes[j-1] = excelFreeTime;
				}
				else {
					freeTimes[j-1] = "empty";
				}
			}
			teacher[i-1].freeTime = freeTimes;
			totalCoursesCount += teacher[i-1].courses.length;


		}
		//	    for(int i=0;i<rowNumber;i++) {
		//	    	System.out.println(Arrays.toString(teacher[i].courses));
		//	    	System.out.println(teacher[i].teacherInitial);
		//	    	System.out.println(Arrays.toString(teacher[i].freeTime));                   
		//		    }
		//	    System.out.println(totalCoursesCount);
		String[] totalCoursesStore = new String[totalCoursesCount];
		int index = 0;
		for(int i=0;i<rowNumber;i++) {
			int stringLength = teacher[i].courses.length;
			System.arraycopy(teacher[i].courses, 0, totalCoursesStore, index, stringLength);
			index += stringLength;
		}


		String[][] freeTimeArray;

		for(int i=0;i<rowNumber;i++) {
			String[] str = teacher[i].freeTime;
			String[][] teachersFreeTime = getfreetime(str); 
			teacher[i].freeTimeArray = teachersFreeTime;

		}

		double[][] days = {{8.30,10.00},{10.00,11.30},{11.30,1.00},{2.00,3.30},{3.30,5.00},{8.30,11.30},{8.30,1.00},{9.00,12.00},{10.00,1.00},{2.00,5.00}};
		int[][] teachersSlot = new int[noOfDays][5];

		for(int t=0;t<rowNumber;t++) {
			for(int i=1;i<6;i++) {
				for(int j=0;j<teacher[t].freeTimeArray[i].length;j++) {
					double startingTime, endingTime; 
					String string = teacher[t].freeTimeArray[i][j];
					//in this block of code, the time is changed to a numerical format. For example, 8:30am-1:00pm is converted to starting time = 8.3 and ending time = 1.0. This is done to compare time and put the values of the free time into a two dimensional array 
					if(!string.equals("empty")) {
						string = string.replaceAll("am", "");
						string = string.replaceAll("pm", ""); 
						String[] splitTheTwoTimes = string.split("-");
						String[] getSeparatedHoursAndMinutes1 = splitTheTwoTimes[0].split(":");
						String[] getSeparatedHoursAndMinutes2 = splitTheTwoTimes[1].split(":");
						startingTime = Integer.parseInt(getSeparatedHoursAndMinutes1[0]) + (Integer.parseInt(getSeparatedHoursAndMinutes1[1]))/100.0;
						endingTime = Integer.parseInt(getSeparatedHoursAndMinutes2[0]) + (Integer.parseInt(getSeparatedHoursAndMinutes2[1]))/100.0;
//						for(double[] day:days) {
//							if(startingTime == day[0] && endingTime == day[1]) {
//								teachersSlot[][] = 1;
//							}
						}	
					}
				}
			}
		}



	}
	public static String[][] getfreetime(String[] freeTime) {
		int noOfDays = 7;
		String[][] freeTimeArray = new String[noOfDays][];
		for(int i=0;i<noOfDays;i++) {
			String[] str = freeTime[i].split(";");
			freeTimeArray[i] = new String[str.length];
			System.arraycopy(str, 0, freeTimeArray[i], 0, str.length);
		}
		return freeTimeArray;

	}

	public static String[] removeDuplicates(String[] string) {
		int Stringlength = string.length;
		String[] uniqueString = new String[Stringlength];

		Arrays.sort(string);

		int j=0;
		for(int i=0;i<Stringlength-1;i++) {
			if(string[i]!=string[i+1]) {
				uniqueString[j++] = string[i];
			}
		}
		uniqueString[j++] = string[Stringlength-1];


		return uniqueString;
	}

	public static String[] removeNullValues(String[] strings) {
		List<String>nonNullString = new ArrayList<String>();
		for(String string: strings) {
			if(string!=null) {
				nonNullString.add(string);
			}
		}
		String [] beautifiedString = nonNullString.toArray(new String[nonNullString.size()]); 

		return beautifiedString;
	}
}