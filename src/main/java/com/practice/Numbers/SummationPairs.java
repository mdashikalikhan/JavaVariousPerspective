package com.practice.Numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class SummationPairs {

	/**
	 * 
	 * @param args
	 * 
	 * SUM = N
	 * 
	 * SET1 = {n1,n2,n3,n4}
	 * SET1 = {n5,n6,n7,n8}
	 */
	public static void main(String[] args) {
		
		System.out.println("SUMMATION= " );
		Scanner summationInput = new Scanner(System.in);
		int sum = summationInput.nextInt();
		
		System.out.println("Number of elements in SET");
		
		Scanner setSizeInput = new Scanner(System.in);
		
		while(setSizeInput.hasNextInt()) {
			
				int noOfElements =  setSizeInput.nextInt();
				System.out.println("Give "+ noOfElements  +" Set Elements");
				
				int[] dataSetArray = new int [noOfElements];
				
				for(int i=0; i<noOfElements; i++) {
					dataSetArray[i] = new Scanner(System.in).nextInt();
				}
				printPairs(dataSetArray,  sum);
				System.out.println("Number of elements in SET");
		}
		
	}
	
	public static void printPairs(int[] dataSetArray, int sum) {
		
		Map<Integer, Integer> mapNumbers = new HashMap<Integer, Integer>();
		
		for(int data : dataSetArray) {
			if(mapNumbers.containsKey(sum-data) && mapNumbers.get(sum-data)==0) {
					System.out.println((sum-data) + ", " + data);
					mapNumbers.put((sum-data), mapNumbers.get(sum-data)+1);
			} else if (!mapNumbers.containsKey(data)) {
				mapNumbers.put(data, 0);
			} 
		}
		
	}
	
	public static int countPairs(int[] dataSetArray, int sum) {

		Map<Integer, Integer> mapNumbers = new HashMap<Integer, Integer>();
		int countPairs = 0;
		for (int data : dataSetArray) {
			if (mapNumbers.containsKey(sum - data) && mapNumbers.get(sum - data) == 0) {
				countPairs++;
				mapNumbers.put((sum - data), mapNumbers.get(sum - data) + 1);
			} else if (!mapNumbers.containsKey(data)) {
				mapNumbers.put(data, 0);
			}
		}

		return countPairs;
	}
}
