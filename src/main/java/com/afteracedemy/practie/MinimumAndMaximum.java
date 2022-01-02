package com.afteracedemy.practie;

import java.util.Arrays;

public class MinimumAndMaximum {
	public static void main(String[] args) {
		int[] arr = {23,32,90,-90,-901,23,4332,9087};
		int[] minMax = comparisonInPairsMethod(arr);
		System.out.println(Arrays.toString(minMax));
	}
	static int[] comparisonInPairsMethod(int[] arr) {
		int[] ans = new int[2];
		
		int n =arr.length;
		int i;
		int min, max;
		
		if(n%2==0) {
			if(arr[0]>arr[1]) {
				max = arr[0];
				min = arr[1];
			} else {
				max = arr[1];
				min = arr[0];
			}
			
			i=2;
		} else {
			min = max = arr[0];
			i=1;
		}
		
		while(i<n) {
			
			if(arr[i]>arr[i+1]) {
				if(max<arr[i]) {
					max=arr[i];
				}
				if(min>arr[i+1]) {
					min=arr[i+1];
				}
			} else {
				if(max<arr[i+1]) {
					max=arr[i+1];
				}
				if(min>arr[i]) {
					min=arr[i];
				}
			}
			
			i+=2;
		}
		
		ans[0]=min;
		ans[1]=max;
		return ans;
	}
}
