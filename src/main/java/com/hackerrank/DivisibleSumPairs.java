package com.hackerrank;

public class DivisibleSumPairs {

	public static void main(String[] args) {
		int[] arr = {1, 4, 10, 12, 16, 8, 3};
		System.out.println(divisibleSumPairs(7, 4, arr));
	}
	
	static int divisibleSumPairs(int n, int k, int[] ar) {
		
		int arr_k[] = new int[k];
		int sum = 0;
		
		for(int i=0; i<k; i++){
			arr_k[i] = 0;
		}
		for(int i=0; i<ar.length; i++) {
			int mod = ar[i]%k;
			arr_k[mod]++;
		}
		
		sum = arr_k[0] * (arr_k[0]-1) / 2;
		
		for(int i=1; i<= k/2 && i!= k-i; i++) {
			sum+= arr_k[i] * arr_k[k-i];
		}
		
		if(k%2==0) {
			sum+=arr_k[k/2] * (arr_k[k/2]-1) / 2;
		}
		
		return sum;


    }

}
