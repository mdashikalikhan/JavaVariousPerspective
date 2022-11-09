package com.educative.twopointer;

import java.util.Arrays;

public class DutchFlag {
	public static void main(String[] args) {
		int[] arr = {1,2,0,0,1,0,2,1,2,0,2,0,1,1,1,0,1,0,1,2};
		int left = 0;
		int right = arr.length-1;
		for(int i=0; i<right; ) {
			if(arr[i]==0) {
				int t = arr[left];
				arr[left] = arr[i];
				arr[i] = t;
				i++;
				left++;
			} else if(arr[i]==1) {
				i++;
			} else {
				int t = arr[i];
				arr[i] = arr[right];
				arr[right] = t;
				right--;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
