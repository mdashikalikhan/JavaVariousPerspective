package com.practice;

public class CountNonDivisible {

	public static void main(String[] args) {
		int[] A = {3,1,2,3,6};
		
		int n = A.length * 2 + 1;
		
		int[] occurrences = new int[n];
		
		for(int val : A) {
			occurrences[val]++;
		}
		
		for(int val : occurrences) {
			System.out.println(val);
		}
		
		for(int i=2; i*i<=n; i++) {
		}
	}

}
