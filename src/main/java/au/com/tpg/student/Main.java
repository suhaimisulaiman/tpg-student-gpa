package au.com.tpg.student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String args[]){
		ClassLoader classLoader = Main.class.getClassLoader();
	    File file = new File(classLoader.getResource("studentList.txt").getFile());
	    
	    List<Student> studentList = new ArrayList<Student>();
	    
	    try {
			List<String> rawData = FileUtils.readLines(file);
			
			boolean isHeader = true;
			
			for(String data: rawData){
				if(isHeader){
					isHeader = false;
					continue;
				}
				
				String studentData[] = data.split("\t");
				Student student = new Student();
				student.setStudentId(Integer.parseInt(studentData[0]));
				student.setStudentName(studentData[1]);
				student.setStudentGpa(Double.parseDouble(studentData[2]));
				
				studentList.add(student);
				
			}
			
			StudentComparator comparator = new StudentComparator();
			Collections.sort(studentList, comparator);
			for(Student student: studentList){
				System.out.println(student.getStudentId() + "\t" + student.getStudentName() + "\t" 
						+ student.getStudentGpa());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
