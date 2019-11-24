package com.feature.java8.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class BiFunctionExample {

	static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunction = (students,
			studentPredicate) -> {
		Map<String, Double> studentGradeMap = new HashMap<>();

		students.forEach(student -> {
			if (studentPredicate.test(student)) {
				studentGradeMap.put(student.getName(), student.getGpa());
			}
		});

		return studentGradeMap;
	};

	public static void main(String[] args) {
		System.out.println(biFunction.apply(StudentDatabase.getAllStudents(), PredicateStudentExample.p2));
	}

}
