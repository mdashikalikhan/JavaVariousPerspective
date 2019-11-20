package com.feature.java8.functionalInterfaces;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class PredicateAndConsumerExample {

	Predicate<Student> p1 = s -> s.getGradeLevel() >= 3;

	Predicate<Student> p2 = s -> s.getGpa() >= 3.5;

	BiConsumer<String, List<String>> studentBiConsumer = (name, activities) -> System.out
			.println(name + ": " + activities);
	
	Consumer<Student> studentConsumer = student->{
		if(p1.and(p2).test(student)) {
			studentBiConsumer.accept(student.getName(), student.getActivities());
		}
	};
	
	public void printNamesAndActivities(List<Student> studentList) {
		studentList.forEach(studentConsumer);
	}

	public static void main(String[] args) {
		List<Student> studentList = StudentDatabase.getAllStudents();
		new PredicateAndConsumerExample().printNamesAndActivities(studentList );

	}

}
