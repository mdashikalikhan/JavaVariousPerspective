package com.feature.java8.functionalInterfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class FunctionStudentExample {

	static Function<List<Student>, Map<String, Double>> studentFunction = students -> {
		Map<String, Double> studentsGradeMap = new HashMap<>();
		students.forEach(student -> {
			if(PredicateStudentExample.p1.test(student)) {
				studentsGradeMap.put(student.getName(), student.getGpa());
			}
		});
		return studentsGradeMap;
	};

	public static void main(String[] args) {
		System.out.println(studentFunction.apply(StudentDatabase.getAllStudents()));
	}

}
