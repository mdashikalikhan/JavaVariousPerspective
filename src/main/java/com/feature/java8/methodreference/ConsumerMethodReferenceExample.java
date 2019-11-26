package com.feature.java8.methodreference;

import java.util.function.Consumer;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class ConsumerMethodReferenceExample {

	static Consumer<Student> c1 = s -> System.out.println(s);
	static Consumer<Student> c2 = System.out::println;
	static Consumer<Student> c3 = Student::printListOfActivities;
	
	public static void main(String[] args) {
		StudentDatabase.getAllStudents().forEach(c3);
	}

}
