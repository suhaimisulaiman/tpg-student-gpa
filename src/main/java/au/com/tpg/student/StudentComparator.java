package au.com.tpg.student;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student firstStudent, Student secondStudent) {
		if(firstStudent.getStudentGpa() < secondStudent.getStudentGpa()){
			return 1;
		} else if(firstStudent.getStudentGpa() > secondStudent.getStudentGpa()){
			return -1;
		} else {
			if(firstStudent.getStudentName().compareToIgnoreCase(secondStudent.getStudentName()) < 0){
				return -1;
			} else if(firstStudent.getStudentName().compareToIgnoreCase(secondStudent.getStudentName()) > 0){
				return 1;
			} else if(firstStudent.getStudentId() < secondStudent.getStudentId()){
				return -1;
			} else{
				return 1;
			}
		}
			
	}
}
