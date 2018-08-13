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

		System.out.println("SUMMATION= ");
		Scanner summationInput = new Scanner(System.in);
		int sum = summationInput.nextInt();

		System.out.println("Number of elements in SET");

		Scanner setSizeInput = new Scanner(System.in);

		int noOfElements = setSizeInput.nextInt();
		System.out.println("Give " + noOfElements + " Set Elements");

		int[] dataSetArray = new int[noOfElements];

		for (int i = 0; i < noOfElements; i++) {
			dataSetArray[i] = new Scanner(System.in).nextInt();
		}
		printPairs(dataSetArray, sum);
		System.out.println("Total Pair: " + SumPairs(dataSetArray, sum));
		int input[]={1,5,66,2,3,4,7,0,2,5};
		int k = 7;
		System.out.println("Total Pair: " + SumPairs(input, k));

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
	
	public static int SumPairs(int[] input, int k) {

	    Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
	    int tmp = 0;
	    for (int data : input) {
	        if (pairs.containsKey(k - data) && pairs.get(k - data) == 0) {
	            tmp++;
	            pairs.put((k - data), pairs.get(k - data) + 1);
	        } else if (!pairs.containsKey(data)) {
	            pairs.put(data, 0);
	        }
	    }

	    return tmp;
	}
}
