package com.leetcode.practice;

public class MinimumSortingWindow {
    public static void main(String[] args) {
        int[] nums={1,3,2,3,3};//{1,2,3,4};//{2,6,4,8,10,9,15};//{1,2,5,3,7,10,9,12};

        
        int low = 0;
        int high = nums.length - 1;

        while( low<high && nums[low]<=nums[low+1]){
            low++;
        }
        System.out.println(low);

        if(low==high){
            return;
        }

        while(high>low && nums[high]>=nums[high-1]){
            high--;
        }
        System.out.println(high);
        int min = nums[low];
        int max = nums[high];
        for(int i=low; i<=high; i++){
            if(nums[i]<min){
               min = nums[i]; 
            } else if(nums[i]>max){
                max = nums[i];
            }
        }
        for(int i=low-1; i>=0; i--){
            if(min<nums[i]){
                low--;
            }
        }
        for(int i=high+1; i<=nums.length-1; i++){
            if(max>nums[i]){
                high++;
            }
        }

        System.out.println(low + " " +high);


    }
}
