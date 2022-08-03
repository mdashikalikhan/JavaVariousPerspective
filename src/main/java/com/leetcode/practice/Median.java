package com.leetcode.practice;

public class Median {
	public static void main(String[] args) {
		int nums[] = new int[] {5,15,7,9,20,25,21, 25};
		
		System.out.println(nums.length);
		
		int median = 0;
		
		int k = nums.length - 1;
		
		if(nums.length%2==0) {
			
			int mid1 = k/2;
			int mid2 = mid1 + 1;
			
			int val1 = getValueAtPosK(nums, mid1, 0, nums.length-1);
			int val2 = getValueAtPosK(nums, mid2, 0, nums.length-1);
			
			median = (val1+val2) / 2;
			
			System.out.println(val1 + "  " + val2);
			
		} else {
			int mid = k/2;
			median = getValueAtPosK(nums, mid, 0, nums.length-1);
		}
		System.out.println(median);
	}
	
	public static int getValueAtPosK(int[] nums, int k, int left, int right) {
		
		int pos = partition(nums, left, right);
		
		if(pos==k) {
			return nums[pos];
		} else if(pos>k) {
			return getValueAtPosK(nums, k, left, pos - 1);
		} else {
			return getValueAtPosK(nums, k, pos+1, right);
		}
		
	}
	
	public static void swap(int[] nums, int l, int r) {
		/*nums[l] = nums[l] - nums[r];
		nums[r] = nums[r] + nums[l];
		nums[l] = nums[r] - nums[l];*/
		int t = nums[l];
		nums[l] = nums[r];
		nums[r] = t;
	}
	
	public static int partition(int[] nums, int left, int right) {
		
		if(left == right) {
			return left;
		}
		
		int pivot = left;
		
		for(int i= left; i<right; i++) {
			if(nums[right]>nums[i]) {
				swap(nums, i, pivot);
				pivot++;
			}
		}
		
		swap(nums, pivot, right);
		
		return pivot;
	}
}
