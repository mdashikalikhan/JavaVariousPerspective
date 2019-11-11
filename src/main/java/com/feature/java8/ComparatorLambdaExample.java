package com.feature.java8;

import java.util.Comparator;


public class ComparatorLambdaExample {

	public ComparatorLambdaExample() {
	}
	
	public static void main(String[] args) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		
		System.out.println("o1 compare to o2 is " + comparator.compare(3, 2));
		
		Comparator<Integer> lambda = (Integer a, Integer b) -> {return a.compareTo(b);};
		
		System.out.println("o1 compare to o2 using lambda is " + lambda.compare(3, 2));
		
		Comparator<Integer> lambda1 = (a, b) -> a.compareTo(b);
		
		System.out.println("o1 compare to o2 using lambda1 is " + lambda1.compare(3, 2));
		
	}

}
