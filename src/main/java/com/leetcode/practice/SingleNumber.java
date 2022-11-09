package com.leetcode.practice;

public class SingleNumber {
	public static void main(String[] args) {
		int[] A = {4,-3,1,4,-3};
		
		System.out.println(singleNumber(A));
	}
	public static int singleNumber(int[] nums) {
        
		if(nums.length==1) {
			return nums[0];
		}
		
		double sumPart1 = 0;
        double sumPart2 = 0;
        double sumPart3 = nums[nums.length-1];
        
        
        
        int lenPart1 = nums.length/2;
        int lenPart2 = lenPart1 * 2;
        for(int i=0; i<lenPart1; i++){
            sumPart1 += nums[i];
        }
        
        for(int i=lenPart1; i<lenPart2; i++){
            sumPart2 += nums[i];
        }
        
        System.out.println(sumPart1 + "~" + sumPart2 + "~" + sumPart3);
        
        if(sumPart1==sumPart2) {
        	return (int)sumPart3;
        } else if(sumPart1==sumPart3) {
        	return (int)sumPart2;
        } else if(sumPart2==sumPart3) {
        	return (int) sumPart1;
        }
        
		/*double diff = sumPart1>sumPart2 ? sumPart1-sumPart2:sumPart2-sumPart1;
		diff = diff>sumPart3?diff-sumPart3:sumPart3-diff;*/
        
        double diff = sumPart1-sumPart2-sumPart3;
        
        return (int)diff;
    }
}
