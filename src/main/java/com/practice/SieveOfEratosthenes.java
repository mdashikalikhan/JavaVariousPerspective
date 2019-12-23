package com.practice;

import java.util.Vector;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		//printPrimeList(10000);
		
		/*for(int x : buildArrayWithSmallestPrimeFactor(100)) {
			System.out.println(x);
		}*/
		
		int[] F = buildArrayWithSmallestPrimeFactor(100);
		for(int i=0; i<F.length; i++) {
			System.out.println(i + ": " + F[i]);
		}
		
		for(int factor : factorization(30, F)) {
			System.out.println(factor);
		}
	}
	
	public static void printPrimeList(int n) {
		boolean[] prime = new boolean[n+1];
		
		prime[0] = prime[1] = false;
		
		for(int i=2; i<=n; i++) {
			prime[i]  = true;
		}
		
		for(int i=2; i*i<=n; i++) {
			if(prime[i]==true) {
				for(int j=i*2; j<=n; j+=i) {
					prime[j] = false;
				}
			}
		}
		
		for(int i=0; i<=n; i++) {
			if(prime[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static int[] buildArrayWithSmallestPrimeFactor(int n) {
		int[] factors = new int[n+1];
		
		for(int i=2; i*i<=n; i++) {
			if(factors[i]==0) {
				for(int j=i*2; j<=n; j+=i) {
					if(factors[j]==0) {
						factors[j] = i;
					}
				}
			}
		}
		
		return factors;
	}
	
	static Vector<Integer> factorization(int x, int F[]) {
		Vector<Integer> primeFactors = new Vector<>();
		while(F[x]!=0) {
			primeFactors.add(F[x]);
			x = x / F[x];
		}
		primeFactors.add(x);
		return primeFactors;
	}

}
