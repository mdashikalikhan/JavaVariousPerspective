package com.practice;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = { 3, 8, 9, 7, 6};
		int	    K = 3;
		int[] ret = new int[A.length]; 
		for (int i =0; i<A.length; i++) {
			ret[(i+K)%A.length] = A[i]; 
		}
		
		for(int i : ret) {
			System.out.println(i);
		}
		
		double r = Math.ceil(5 * 1.0 / 3);
		System.out.println(Math.ceil(1*1.0/5));
		
		
		
	}
	
	public void test() {
		Math.abs(1.2);
	}

}
