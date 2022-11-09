package com.cp.practice;

import java.util.*;

public class SubarraySum {
	
	public static void main(String[] args) {
		int[] nums= {1,1,1};//{1, 1, 5, 2, 1, 3, 10, 2, 1};
		int k=3;//21;
		System.out.println(Arrays.toString( subarraySum(nums, k)));
	}
	
	public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] result = new int[2];
        
       
        
        int sum = 0;
        
        map.put(0, -1);
        
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-target)){
                result[0] = map.get(sum-target)+1;
                result[1] = i;
                break;
                
            }
            else {
                map.put(sum, i);
            }
        }
        
        return result;
        
    }
}
