package com.leetcode.practice;

import java.util.*;

public class SubsetCheck {
	public static void main(String[] args) {
		int[] n = {1,2,3,4};
		//System.out.println(subsetsF(n));
		
		System.out.println(21>>2);
	}

public static List<List<Integer>> subsetsF(int[] nums) {
        
        List<List<Integer>> vals = new ArrayList<>();
        
        int k = nums.length;
        int countSubsets = (int)Math.pow(2, k) - 1;
        
        
        for(int i= 0; i<=countSubsets; i++){
            
            List<Integer> l = new ArrayList<>();
            
            for(int j=k-1; j>=0; j--){
                int bit = i >> j;
                if((bit&1)==1) {
                	l.add(nums[j]);
                }
            }
            
            vals.add(l);
            
            
        }
        
       
        return vals;
        
    }
	
	public static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> vals = new ArrayList<>();

		List<Integer> numList = new ArrayList<>();

		for ( int n : nums ) {
			numList.add(n);
		}

		List<Integer> emptyList = new ArrayList<>();
		vals.add(emptyList);
		getSets(numList, 0, nums.length, vals);

		return vals;

	}

	public static void getSets(List<Integer> nums, int start, int end, List<List<Integer>> vals) {
		

		vals.add(nums.subList(start, end));
		
		if(end-start<=1) {
			return;
		}
		getSets(nums, start, start + 1, vals);
		getSets(nums, start + 1, end, vals);
	}
}
