package com.feature.java8.data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {

	public static List<Student> getAllStudents() {

		Student std1 = new Student("1", 2, 2.5, "Male",
				Arrays.asList("swimming", "playog", "basketball", "volleyball"));
		
		Student std2 = new Student("2", 2, 2.5, "Male",
				Arrays.asList("swimming", "playog", "gymnastics", "soccer"));
		
		Student std3 = new Student("3", 2, 2.5, "Male",
				Arrays.asList("swimming", "football", "gymnastics", "soccer"));

		return Arrays.asList(std1, std2, std3);
	}
}
