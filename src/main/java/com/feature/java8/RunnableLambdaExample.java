package com.feature.java8;

public class RunnableLambdaExample {

	public RunnableLambdaExample() {
	}

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside Runnable 1");
			}
		};

		new Thread(runnable).start();

		// Java 8 - Lambda Syntax

		// ()->{}
		// assigning a lambda to a variable.

		Runnable runnableLambda = () -> {
			System.out.println("Inside 2");
			System.out.println("Inside 3");
		};
		
		new Thread(runnableLambda).start();
		
		Runnable runnableLambdaSingleStaement = () -> 
			System.out.println("Inside 4");
		;
		
		new Thread(runnableLambdaSingleStaement).start();
		
		new Thread(() -> System.out.println("Inside Thread 5")).start();
	}

}
