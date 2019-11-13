package com.feature.java8.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> consumer = (s) -> {
			if (s != null)
				System.out.println(s.toUpperCase());
			else
				System.out.println(s);
		};

		consumer.accept("java8");

		consumer.accept(null);
		
		printStudents();
	}
	
	public static void printStudents() {
		Consumer<Student> student = std -> System.out.println(std);
		List<Student> studentList = StudentDatabase.getAllStudents();
		studentList.forEach(student);
	}

}
