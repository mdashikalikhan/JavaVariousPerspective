package com.practice;

public class Question2 {
	   public static void main(String[] args) {
	      int a = 5;
	      int b = 7;
	      swap(a,b);
	      System.out.println(a + ", " + b);
	   }
	   public static void swap(int a, int b) {
	      int temp = a;
	      a = b;
	      b = temp;
	   }
	}
