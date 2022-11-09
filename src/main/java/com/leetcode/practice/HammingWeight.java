package com.leetcode.practice;

public class HammingWeight {
	public static void main(String[] args) {
		int a = -7;
		int count = 0;
		while(a!=0) {
			a = a & (a-1);
			count++;
		}
		
		System.out.println(count);
		
	}
	
}
