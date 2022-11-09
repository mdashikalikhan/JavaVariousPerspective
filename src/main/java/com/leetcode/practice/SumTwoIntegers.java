package com.leetcode.practice;

public class SumTwoIntegers {

	public static void main(String[] args) {
		System.out.println(getSum(10, -12));
	}

	public static int getSum(int a, int b) {
		int carry = 0;
		int sum = 0;
		do {
			sum = a ^ b;
			carry = a & b;
			carry = carry << 1;
			
			a = sum;
			b = carry;
		} while(carry!=0);
		return sum;
	}

}
