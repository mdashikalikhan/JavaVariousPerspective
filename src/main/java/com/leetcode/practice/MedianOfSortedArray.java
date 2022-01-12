package com.leetcode.practice;

public class MedianOfSortedArray {

	public static void main(String[] args) {
		int[] A ={1,2};// {1,2,3,4};
		int[] B = {3,4}; //{3,4,6,7,8,9,12};
		
		System.out.println(getMedian(B, A));
		
	}
	
	public static double getMedian(int[] A, int[] B) {
		if(A.length>B.length) {
			return  getMedian(B, A);
		}
		double median = 0;
		int totalLength = A.length + B.length;
		int start = 0;
		int end = A.length;
		
		while(start<=end) {
			int leftA = (start+(end-start)/2);
			int leftB = (totalLength + 1)/2 - leftA;
			
			int maxLeftA = Integer.MIN_VALUE;
			int minRightA = Integer.MAX_VALUE;
			
			int maxLeftB = Integer.MIN_VALUE;
			int minRightB = Integer.MAX_VALUE;
			
			if(leftA>0) {
				maxLeftA = A[leftA-1];
			}
			if(leftA<A.length) {
				minRightA = A[leftA];
			}
			
			if(leftB>0) {
				maxLeftB = B[leftB-1];
			}
			
			if(leftB<B.length) {
			
				minRightB = B[leftB];
			}
			
			if(maxLeftA<=minRightB && maxLeftB<=minRightA) {
				if(totalLength%2==0) {
					median = (double)(Math.max(maxLeftA, maxLeftB) +  Math.min(minRightA, minRightB)) / 2;
				} else {
					median = Math.max(maxLeftA, maxLeftB);
				}
				break;
			} else if(maxLeftB>minRightA) {
				start = leftA + 1;
			} else {
				end = leftA - 1;
			}
			
			
		}
		
		return median;
	}
	
	
}
