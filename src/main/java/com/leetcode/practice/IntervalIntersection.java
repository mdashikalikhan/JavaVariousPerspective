package com.leetcode.practice;

import java.util.*;

public class IntervalIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] secondList = {{0,2},{5,10},{13,23},{24,25}};
        int result[][] =  intervalIntersection(firstList, secondList);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i][0] + "  " + result[i][1]);
        }
    }
    
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        /*
         * System.out.println(firstList.length);
         * System.out.println(secondList.length);
         */
        int len1 = firstList.length;
        int len2 = secondList.length;
        int i=0;
        int j=0;
        
        List<int[]> list = new ArrayList<>();
        
        while(i<len1 && j<len2) {
            if(firstList[i][1]<secondList[j][0]) {
                i++;
                continue;
            } 
            
            if(secondList[j][1]<firstList[i][0]) {
                j++;
                continue;
            }
            
            int val1 = Math.max(firstList[i][0], secondList[j][0]);
            int val2 = Math.min(firstList[i][1], secondList[j][1]);
            
            list.add(new int[] {val1, val2});
            
            if(firstList[i][1]<secondList[j][1]) {
                i++;
            } else {
                j++;
            }
            
        }
        
        list.stream().forEach(arr->{System.out.println(arr[0]+ " " +arr[1]);});
        
        
        
        return list.toArray(new int[list.size()][]);
    }
}
