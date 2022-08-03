package com.leetcode.practice;

public class StringOperation {
	public static void main(String[] args) {
		String s ="abcleet";
		//System.out.println(s.substring(1, 3));
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<s.length(); j++) {
				System.out.println(s.substring(0, i+1) + "  " + s.substring(j));
			}
		}
	}
}
