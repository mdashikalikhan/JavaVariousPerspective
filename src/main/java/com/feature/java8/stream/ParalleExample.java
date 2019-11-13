package com.feature.java8.stream;

import java.util.Arrays;

public class ParalleExample {

	public static void main(String[] args) {
		Arrays.asList(100, 1, 4, 5, 6, 7).stream().forEach(i -> System.out.print(i + " "));

		System.out.println();

		Arrays.asList(100, 1, 4, 5, 6, 7).parallelStream().forEach(i -> System.out.print(i + " "));
	}
}
