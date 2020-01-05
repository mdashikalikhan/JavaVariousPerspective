package com.practice;

public class CountNonDivisible {

	public static void main(String[] args) {
		int[] A = /*{ 2, 4 }*/  { 3, 1, 2, 3, 6, 9} ;

		int n = A.length * 2 + 1;

		int[] occurrences = new int[n];
		int[] divisors = new int[n];

		for (int i = 0; i < n; i++) {
			occurrences[i] = 0;
			divisors[i] = 0;
		}

		
		 

		int[] nonDivisors = new int[A.length];

		for (int val : A) {
			occurrences[val]++;
		}

		
		
		for(int i=1; i<n; i++) {
			if(occurrences[i]==0) continue;
			for(int j=1; j*j<=i; j++) {
				if(i%j==0) {
					divisors[i] += occurrences[j];
					
					if(i/j != j) {
						divisors[i] += occurrences[i/j];
					}
				}
			}
			
		}

		for (int i = 0; i < n; i++) {
			System.out.println(i + ": " + divisors[i]);
		}

		System.out.println("-------------------------");

		for (int i = 0; i < A.length; i++) {
			nonDivisors[i] = A.length - divisors[A[i]] ;
		}

		for (int val : nonDivisors) {
			System.out.println(val);
		}

	}

}
