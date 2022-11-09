package com.leetcode.practice;

import java.util.*;

public class KthLargest {
	
	public static void main(String[] args) {
		KthLargest app = new KthLargest();
		int nums[] = {3,2,1,5,6,4};
		int res = app.findKthLargest(nums, 2);
		System.out.println(res);
	}
	
	public int findKthLargest(int[] nums, int k) {
		//Arrays.sort(nums);

		int pivot = nums.length - 1;
		int left = 0;
		int right = pivot - 1;
		System.out.println(left + " " + right + " " + pivot);
		pivot = partition(nums, pivot, left, right);
		System.out.println(left + " " + right + " " + pivot);
		System.out.println(Arrays.toString(nums));
		while (nums.length - k != pivot) {

			if (nums.length - k < pivot) {
				/*pivot = pivot - 1;
				right = pivot - 1;*/
				/*if (left > right) {
					right = left;
				}
				if(left>pivot) {
					pivot = left;
				}*/
				
				right = pivot - 1;
				
				if(right-left+1>=2) {
					pivot = right;
					right = pivot - 1;
				} else  {
					pivot = right;
				} 
				
				pivot = partition(nums, pivot, left, right);
				System.out.println(left + " " + right + " " + pivot);
				System.out.println(Arrays.toString(nums));
			} else {

				/*left = pivot + 1;
				
				pivot = right;
				right = pivot - 1;*/

				/*if (left > right) {
					right = left;
				}
				if(left>pivot) {
					pivot = left;
				}*/
				
				left = pivot + 1;
				right = nums.length - 1;
				if(right-left+1>=2) {
					pivot = right;
					right = pivot - 1;
				} else  {
					pivot = right;
				} 
				
				pivot = partition(nums, pivot, left, right);
				System.out.println(left + " " + right + " " + pivot);
				System.out.println(Arrays.toString(nums));
			}
		}
		System.out.println(Arrays.toString(nums));
		return nums[pivot];
	}

	public int partition(int[] nums, int pivot, int left, int right) {
		int cPivot = left;
		if (left == right) {
			if(nums[left]>nums[pivot]) {
				int t = nums[pivot];
				nums[pivot] = nums[left];
				nums[left] = t;
				return left;
			}
			return pivot;
		}
		for ( int i = left; i <= right; i++ ) {
			if (nums[i] <= nums[pivot]) {
				if (i > cPivot) {
					int t = nums[cPivot];
					nums[cPivot] = nums[i];
					nums[i] = t;
				}
				cPivot++;
			}
		}
		int t = nums[pivot];
		nums[pivot] = nums[cPivot];
		nums[cPivot] = t;

		return cPivot;
	}
}
