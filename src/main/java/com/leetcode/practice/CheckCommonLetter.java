package com.leetcode.practice;

public class CheckCommonLetter {
	public static void main(String[] args) {
		String t1 = "000111";
		int a = Integer.parseInt(t1, 2);
		System.out.println(a);
		
		String t2 = "111000";
		int b = Integer.parseInt(t2, 2);
		System.out.println(b);
		
		int r = a&b;
		System.out.println(r);
		
	}
}
