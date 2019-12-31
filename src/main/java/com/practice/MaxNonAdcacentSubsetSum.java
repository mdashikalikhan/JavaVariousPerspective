package com.practice;

public class MaxNonAdcacentSubsetSum {

	public static void main(String[] args) {
		int[] arr = /*{2, 1, 5, 8, 4}*/ {3, 7, 4, 6, 5} /*{ -2, 1, 3, -4, 5 }*/;

		arr[0] = 0 > arr[0] ? 0 : arr[0];
		arr[1] = arr[1] > arr[0] ? arr[1] : arr[0];

		for (int i = 2; i < arr.length; i++) {
			/*System.out.print(arr[i] + " " + arr[i - 2] + " " + arr[i - 1] + " " + (arr[i] + arr[i - 2]) + " ");*/
			
			arr[i] = Math.max(Math.max(arr[i], arr[i - 2]), Math.max(arr[i - 1], arr[i] + arr[i - 2]));
			
			/*System.out.println(arr[i]);*/
		}
		
		System.out.println(arr[arr.length-1]);
		

	}

}
