package com.practice;

public class MaximalSlice {

	public static void main(String[] args) {
		int[] A = {3,2,-6,4,0};
		int cumulative = A[0];
		int maxSlice = A[0];
		
		for(int a : A) {
			cumulative += a;
		}
		
		System.out.println(maxSlice);
	}

}
