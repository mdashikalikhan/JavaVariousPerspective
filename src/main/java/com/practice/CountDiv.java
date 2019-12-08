package com.practice;

public class CountDiv {


	public static void main(String[] args) {
		int a = 10;
		int b = 1001;
		int divisor = 7;
		
		int count;
		if(a%7==0) {
			count = b/divisor - a/divisor +1;
		} else {
			count = b/divisor - a/divisor ;
		}
		System.out.println(count);
	}

}
