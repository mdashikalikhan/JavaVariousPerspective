package com.feature.java8.functionalInterfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
	
	static UnaryOperator<String> unaryOperator = s -> s.concat("default");
	
	public static void main(String[] args) {
		System.out.println(unaryOperator.apply("java8"));
	}

}
