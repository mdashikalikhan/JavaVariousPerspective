package com.hackerrank;

public class MinimumSwaps {

	public static void main(String[] args) {
		int[] arr = {4, 3, 1, 2};
		
		int[] pos = new int[arr.length+1];
		
		int minimumSwaps = 0;
		
		for(int i=0; i<arr.length; i++) {
			pos[arr[i]] = i+1; 
		}
		
		for(int i=1; i<pos.length; i++) {
			System.out.println(arr[i-1] + "   " +pos[i]); 
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i+1 != arr[i]) {
				
				minimumSwaps++;
				
				int t = arr[i];
				
				int currentValuePosition = pos[i+1] - 1;
				
				arr[i] = arr[currentValuePosition]; 
				
				arr[currentValuePosition] = t;
				
				pos[i+1] = i+1;
				
				pos[arr[currentValuePosition]] =currentValuePosition + 1;
					
				
				
			}
		}
		
		System.out.println();
		System.out.println();
		
		for(int i=1; i<pos.length; i++) {
			System.out.println(arr[i-1] + "   " +pos[i]); 
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println(minimumSwaps);
		
	}
	
	

}
