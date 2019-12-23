package com.practice;

public class CountSemiPrimes {

	public static void main(String[] args) {
		int N = 50000;
		
		int[] factors = new int[N+1];
		
		int[] semiPrimes = new int[N+1];
		
		int[] P = {1,4,16};
		int[] Q = {26,10,20};
		
		int[] res = new int[P.length];
		
		for(int i=2; i*i<=N; i++ ) {
			if(factors[i]==0) {
				for(int j=i*2; j<=N; j+=i) {
					if(factors[j]==0) {
						factors[j] = i;
					}
				}
			}
		}
		
		/*for(int f : factors) {
			System.out.println(f);
		}*/
		
		/*for(int i=0; i<=10; i++) {
			System.out.println(i + ": " + factors[i]);
		}*/
		
		int prefixSUm = 0;
		
		for(int i=2; i<=N; i++) {
			
			if(factors[i]!=0 && factors[i/factors[i]]==0) {
				prefixSUm++;
			}
			
			semiPrimes[i] = prefixSUm;
		}
		
		/*for(int i=2; i<=30; i++) {
			System.out.println(i + ": " + semiPrimes[i]);
		}*/
		
		for(int i=0; i<P.length; i++) {
			res[i] =  semiPrimes[Q[i]] - semiPrimes[P[i]-1];
		}
		
		for(int r : res) {
			System.out.println(r);
		}
	}

}
