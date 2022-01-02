package com.afteracedemy.practie;

import java.util.Arrays;

public class QuickSortImplementation {

	public static void main(String[] args) {
		int arr[] = {35, 33, 42, 10, 14, 19, 27, 44, 26, 31};
		//arr = new int[] {4,5,3,12};
		/*System.out.println(Arrays.toString(arr));
		System.out.println(partition(arr, 0, arr.length-1));*/
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int arr[], int start, int end) {
		if(start<end) {
			int pi = partition(arr, start, end);
			quickSort(arr, start, pi-1);
			quickSort(arr, pi+1, end);
		}
		
	}
	
	static int partition(int arr[], int start, int end) {
		
		int pos = start;
		int low = start;
		int high = end - 1;
		int pivot = arr[end];
		
		for(int i=low; i<=high; i++) {
			if(arr[i]<pivot) {
				if(i!=pos) {
					swap(arr, i, pos);
				}
				pos++;
			}
		}
		
		if(pos<end) {
			swap(arr, pos, end);
		}
		
		/*System.out.println(Arrays.toString(arr));*/
		
		return pos;
	}
	
	static void swap(int arr[], int i, int j) {
		
		arr[i] -= arr[j];
		arr[j] += arr[i];
		arr[i] = arr[j] - arr[i];
	}
}
