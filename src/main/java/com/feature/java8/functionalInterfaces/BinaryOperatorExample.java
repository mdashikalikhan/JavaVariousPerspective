package com.feature.java8.functionalInterfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

	static Comparator<Integer> comparator = (a,b)->a.compareTo(b);
	public static void main(String[] args) {
		BinaryOperator<Integer> binaryOperator = (a, b)-> a*b;
		System.out.println(binaryOperator.apply(10, 2));
		
		BinaryOperator<Integer> maxBy = BinaryOperator.maxBy(comparator);
		System.out.println("maxBy: " + maxBy.apply(20, 21));
		
		BinaryOperator<Integer> minBy = BinaryOperator.minBy(comparator);
		System.out.println("minBy: " + minBy.apply(20, 21));
	}

}
