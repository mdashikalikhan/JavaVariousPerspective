package com.practice;

public class MaximalSlice {

	public static void main(String[] args) {
		int[] A = {-2,1};
		int cumulative = A[0];
		int maxSlice = A[0];
		
		for(int i=1; i<A.length; i++) {
			if(cumulative + A[i] > A[i]) {
				cumulative += A[i];
			} else {
				cumulative = A[i];
			}
			if(cumulative > maxSlice)
				maxSlice = cumulative;
			}
		}
		
		System.out.println(maxSlice);
		
		/*int max_ending =0, max_slice = 0;
		for(int a:A) {
			max_ending = max_slice+a>0 ? max_slice+a:0;
			max_slice = max_slice>max_ending ? max_slice : max_ending;
		}
		System.out.println(max_slice);*/
		
		int maxEndingPrevious = A[0];
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
 
        // note: for i=0, it will return A[0] (also for "one element" cases)  
           
        for(int i = 1; i < A.length; i++){
            maxEndingHere = Math.max(A[i], maxEndingPrevious + A[i]); // <--- key point~!!
            maxEndingPrevious = maxEndingHere;
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // update the max (be careful)
        }
        System.out.println(maxSoFar);
        
        System.out.println(221&1);
	}

}
