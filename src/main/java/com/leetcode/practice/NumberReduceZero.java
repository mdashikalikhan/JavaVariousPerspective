package com.leetcode.practice;

public class NumberReduceZero {
	public static void main(String[] args) {
		int n = 7;
		
		n = n>>1;
		
		System.out.println(n);
		
		n = n>>1;
		
		System.out.println(n);
		
		n = n /2;
		
		System.out.println(n);
		
		n=100;
		int count = 0;
		while(n!=0) {
			System.out.println(n);
			if((n&1)==1) {
				count += (n==1)?1:2;
			} else {
				count+=1;
			}
			
			n = n>>1;
		}
		
		System.out.println(count);
		
		char c = '1';
		
		int a = c- 48;
		
		System.out.println(a);
	}
}
