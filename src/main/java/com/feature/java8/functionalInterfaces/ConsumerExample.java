package com.feature.java8.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class ConsumerExample {
	static Consumer<Student> student = std -> System.out.println(std);
	static Consumer<Student> consumer1 = student -> System.out.print(student.getName());
	static Consumer<Student> consumer2 = student -> System.out.println(student.getActivities());
	static List<Student> studentList = StudentDatabase.getAllStudents();

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

		printNamesAndActivities();

		printNamesAndActivitiesUsingCondition();
	}

	public static void printStudents() {

		studentList.forEach(student);
	}

	public static void printNamesAndActivities() {

		studentList.forEach(consumer1.andThen(consumer2));

	}

	public static void printNamesAndActivitiesUsingCondition() {

		studentList.forEach(student -> {

			if (student.getGpa() >= 3) {
				consumer1.andThen(consumer2).accept(student);
			}
		});

	}

}
