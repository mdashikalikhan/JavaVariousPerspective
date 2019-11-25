package com.feature.java8.functionalInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.feature.java8.data.Student;
import com.feature.java8.data.StudentDatabase;

public class SupplierExample {

	public static void main(String[] args) {
		Supplier<Student> studentSupplier = () -> new Student("Ashik", 4, 3.99, "M",
				Arrays.asList("Salat", "Hefz", "Family", "Service", "Programming"));
		
		Supplier<List<Student>> listSupplier = () -> StudentDatabase.getAllStudents();
		
		System.out.println("Student is: " + studentSupplier.get());
		
		System.out.println("Students are: " + listSupplier.get());
	}

}
