package com.cp.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class Backtracktest {
	public static void main(String[] args) {
		int[] nums = {1,2,3,6,7};
		
		int target =7;
		
		//backtrack(nums, target, 0, new ArrayList<Integer>());
		int[][] intervals = {{2,2,},{1,3},{2,4},{2,9},{1,4}};
		Arrays.sort(intervals,(a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
		System.out.println(Arrays.deepToString(intervals));
	}
	
	public static void backtrack(int[]nums, int target,  int start, ArrayList<Integer> tmpList) {
		if(target<=0) return;
		
		for(int i=start; i<nums.length; i++) {
			tmpList.add(nums[i]);
			if(target - nums[i]==0)
			System.out.println(tmpList + " ~~~~~~~~~ " + (target - nums[i]) );
			backtrack(nums, target - nums[i], i, tmpList);
			tmpList.remove(tmpList.size()-1);
		}
	}
}
