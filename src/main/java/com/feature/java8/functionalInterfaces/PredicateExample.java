package com.feature.java8.functionalInterfaces;

import java.util.function.Predicate;

public class PredicateExample {

	static Predicate<Integer> p1 = i -> {
		return i % 2 == 0;
	};
	
	static Predicate<Integer> p2 = i -> i % 2 == 0;
	
	static Predicate<Integer> p3 = i -> i % 5 == 0;
	
	public static void predicateAnd() {
		System.out.println("Predicate And result is: " + p1.and(p3).test(10));
		System.out.println("Predicate And result is: " + p1.and(p3).test(8));
	}
	
	public static void predicateOr() {
		System.out.println("Predicate Or result is: " + p1.or(p3).test(10));
		System.out.println("Predicate Or result is: " + p1.or(p3).test(8));
	}
	
	public static void predicateNegate() {
		System.out.println("Predicate Negate result is: " + p1.or(p3).negate().test(10));
		System.out.println("Predicate Negate result is: " + p1.or(p3).negate().test(8));
		System.out.println("Predicate Negate result is: " + p1.negate().test(9));
	}

	public static void main(String[] args) {
		predicateAnd();
		predicateOr();
		predicateNegate();

	}

}
