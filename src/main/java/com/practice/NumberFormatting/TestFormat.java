package com.practice.NumberFormatting;

public class TestFormat {
	public static void main(String args[]) {
		long n = 461012;
		
		System.out.format("%2d\n", n);
		System.out.format("%012d\n", n);
		System.out.format("%+12d\n", n);
		System.out.format("%+012d\n", n);
		System.out.format("%+,12d\n\n", n);
		
		double pi;
		
		pi = Math.PI;
	}
}
