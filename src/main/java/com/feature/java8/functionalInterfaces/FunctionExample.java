package com.feature.java8.functionalInterfaces;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> func1 = name -> name.toUpperCase();

	static Function<String, String> addSomeString = name -> name.concat("default");

	public static void main(String[] args) {
		System.out.println("Result is: " + func1.apply("java8"));
		System.out.println("Result of andThen is: "
				+ func1.andThen(addSomeString).andThen(addSomeString).andThen(addSomeString).apply("java8"));
		System.out.println("Result of compose is: " + func1.compose(addSomeString).apply("java8"));
	}

}
