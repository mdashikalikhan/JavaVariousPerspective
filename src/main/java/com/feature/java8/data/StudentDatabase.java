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
		
		Student std4 = new Student("4", 3, 3.5, "Male",
				Arrays.asList("swimming", "cricket", "gymnastics", "soccer"));
		
		Student std5 = new Student("5", 3, 3.8, "Male",
				Arrays.asList("swimming", "hockey", "gymnastics", "soccer"));
		
		Student std6 = new Student("6", 4, 4, "Male",
				Arrays.asList("swimming", "shooting", "gymnastics", "soccer"));
		
		Student std7 = new Student("7", 3, 3, "Male",
				Arrays.asList("swimming", "chess", "gymnastics", "soccer"));

		return Arrays.asList(std1, std2, std3, std4, std5, std6, std7);
	}
}
