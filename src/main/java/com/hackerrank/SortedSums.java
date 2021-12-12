package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedSums {

	public static void main(String[] args) {
		Integer[] arr = {3, 9,5,8} /*{10,9,8,7,6,5,100,99,101,110}*/;
		List<Integer> a = Arrays.asList(arr);
		
		Integer[] vals = new Integer[a.size()];
		for(int i=0; i<a.size(); i++) {
			vals[i] = a.get(i);
		}
		vals = Arrays.copyOfRange(vals, 1, vals.length);
		Integer[] f = new Integer[vals.length];
		for(int i=0; i<vals.length; i++) {
			Integer[] tmp = Arrays.copyOfRange(vals, 0, i+1);
			Arrays.sort(tmp);
			int sum = 0;
			for(int j=0; j<tmp.length; j++) {
				sum = sum + (j+1) * tmp[j];
			}
			f[i] = sum; 
		}
		int totalSum = 0;
		for(int val: f) {
			totalSum += val;
		}
		System.out.println(totalSum);
		
		
	}

}
