package com.feature.java8.functionalInterfaces;

import java.util.List;
import java.util.function.Predicate;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class PredicateStudentExample {

	static Predicate<Student> p1 = s->s.getGradeLevel()>=3 ;
	
	static Predicate<Student> p2 = s->s.getGpa()>=3.5 ;

	public static void main(String[] args) {
		/*filterStudentsByGradeLevel();
		filterStudentsByGpa();*/
		filterStudents();
	}
	
	public static void filterStudentsByGradeLevel() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(s->{
			if(p1.test(s)) {
				System.out.println(s);
			}
		});
	}
	
	public static void filterStudentsByGpa() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(s->{
			if(p2.test(s)) {
				System.out.println(s);
			}
		});
	}
	
	public static void filterStudents() {
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(s->{
			if(p2.or(p1).negate().test(s)) {
				System.out.println(s);
			}
		});
	}

}
