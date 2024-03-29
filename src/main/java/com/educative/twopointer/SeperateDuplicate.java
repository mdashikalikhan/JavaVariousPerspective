package com.educative.twopointer;

import java.util.Arrays;

public class SeperateDuplicate {
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
	    System.out.println(SeperateDuplicate.remove(arr));

	    arr = new int[] { 2, 2, 2, 11 };
	    System.out.println(SeperateDuplicate.remove(arr));
	}
	
	public static int remove(int[] arr) {
	    int nextNonDuplicate = 1; // index of the next non-duplicate element
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[nextNonDuplicate - 1] != arr[i]) {
	        arr[nextNonDuplicate] = arr[i];
	        nextNonDuplicate++;
	      }
	    }
	    System.out.println(Arrays.toString(arr));
	    return nextNonDuplicate;
	  }
}
