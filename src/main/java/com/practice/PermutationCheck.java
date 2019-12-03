package com.practice;

public class PermutationCheck {

	public static void main(String[] args) {
		int A[] = {1,4,3};
		boolean[] x = new boolean[10];
		System.out.println(x[9]);
		System.out.println(permCheck(A));
		
	}
	
	static int permCheck(int[]A) {
		int tmp[] = new int[A.length];
		for(int i=0; i< tmp.length; i++) {
			tmp[i] = 0;
		}
		for(int i=0;i<A.length;i++) {
			if(A[i]>A.length || A[i]<=0)
				return 0;
			else if(tmp[A[i]-1] >0)
				return 0;
			else
				tmp[A[i]-1] = A[i];
			
		}
		return 1;
	}

}
