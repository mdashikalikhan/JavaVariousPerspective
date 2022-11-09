package com.leetcode.practice;

public class MergeTwoSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	       
        int k = m + n-1 ;
        
        
        while(n>0){
            if (m==0){
                nums1[k--] = nums2[n-1];
                n--;
            }
            else if(nums2[n-1]>nums1[m-1]){
                nums1[k--] = nums2[n-1];
                n--;
            } else {
                nums1[k--] = nums1[m-1];
                m--;
            }
        }
        
    }
}
