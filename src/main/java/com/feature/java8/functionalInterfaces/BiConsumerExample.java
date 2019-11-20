package com.feature.java8.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class BiConsumerExample {

	public static void main(String[] args) {
		BiConsumer<String, String> biConsumer = (a, b) -> System.out.println("a : " + a + ", b : " + b);

		biConsumer.accept("Java 8", "Java 7");

		BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication is " + (a * b));

		BiConsumer<Integer, Integer> division = (a, b) -> System.out.println("Division is " + (a / b));

		multiply.andThen(division).accept(10, 5);
		
		nameAndActivities();
	}

	public static void nameAndActivities() {
		List<Student> studentLists = StudentDatabase.getAllStudents();

		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out
				.println(name + ": " + activities);
		studentLists.forEach(student->biConsumer.accept(student.getName(), student.getActivities()));
	}
}
