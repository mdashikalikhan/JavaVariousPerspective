package com.practice;

import java.util.Arrays;

public class NumberOfIntersections {

	public static void main(String[] args) {
		int A[] = {1,5,2,1,4,0};
		int startpoint[] = new int[A.length];
		int endpoint[] = new int[A.length];
		int open = 0;
		int intersections = 0;
				
		for(int i=0; i<A.length; i++) {
			startpoint[i] = i - A[i];
			endpoint[i] = i + A[i];
		}
		
		Arrays.sort(startpoint);
		Arrays.sort(endpoint);
		
		int pop = 0;
		
		for(int i=0; i<A.length; i++) {
			if(startpoint[i]<=endpoint[pop]) {
				open++;
			}
			
			if(startpoint[i]>endpoint[pop]) {
				
			}
			
			if(i!=0 && open>0) {
				intersections += open;
			}
		}
		
		System.out.println(intersections);
	}

}
