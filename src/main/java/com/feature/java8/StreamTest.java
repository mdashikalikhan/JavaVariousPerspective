package com.feature.java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("ABC");
		
		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("DEF");
		
		Employee[] emps = {emp1, emp2};
		
		List<Employee> l = Arrays.stream(emps).filter(c->c.getId()==1).collect(Collectors.toList());
		
		for( Employee e : l) {
			System.out.println(e);
		}
	}
}
