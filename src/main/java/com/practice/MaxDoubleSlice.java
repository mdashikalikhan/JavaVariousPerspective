package com.practice;

public class MaxDoubleSlice {

	public static void main(String[] args) {
		int[] A = {3,2,6,-1,4,5,-1,2};
		MaxDoubleSlice m = new MaxDoubleSlice();
		System.out.println(m.solution(A));
	}
	public int solution(int[] A) {
		  int N = A.length;
		  int[] K1 = new int[N];
		  int[] K2 = new int[N];

		  for(int i=0; i<N; i++) {
			  System.out.print(A[i] + " ");
		  }
		  
		  System.out.println();
		  
		  for(int i = 1; i < N-1; i++){
		    K1[i] = Math.max(K1[i-1] + A[i], A[i]);
		  }
		  
		  for(int i=1; i<N-1; i++) {
			  System.out.print(K1[i] + " ");
		  }
		  
		  System.out.println();
		  for(int i = N-2; i > 0; i--){
		    K2[i] = Math.max(K2[i+1]+A[i], A[i]);
		  }
		  
		  for(int i=N-2; i>0; i--) {
			  System.out.print(K2[i] + " ");
		  }
		  
		  System.out.println();

		  int max = 0;

		  for(int i = 1; i < N-1; i++){
		    max = Math.max(max, K1[i-1]+K2[i+1]);
		  }

		  return max;
		}

}
