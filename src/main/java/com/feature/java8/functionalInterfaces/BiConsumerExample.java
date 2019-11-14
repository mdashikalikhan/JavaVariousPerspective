package com.feature.java8.functionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumerExample {

	public static void main(String[] args) {
		BiConsumer<String, String> biConsumer = (a,b)->
		System.out.println("a : " + a + ", b : ");
	}
}
