package com.java.prep.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest {
	public static void main(String[] args) {
		List<Employee> listEmployee = new ArrayList<>();
		Employee e1 = new Employee(1, "ABC", 40);
		Employee e2 = new Employee(2, "DEF", 30);
		Employee e3 = new Employee(3, "GHI", 20);
		Employee e4 = new Employee(4, "JKL", 28);
		
		listEmployee.add(e1);
		listEmployee.add(e2);
		listEmployee.add(e3);
		listEmployee.add(e4);
		
		System.out.println(listEmployee);
		
		Collections.sort(listEmployee, new AgeComparator());
		
		System.out.println(listEmployee);
		
		/*for(int i=1; i<=5; i++) {
			System.out.println(++i);
		}*/
		
	}
}
