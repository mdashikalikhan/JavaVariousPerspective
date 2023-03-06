package com.leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = mergeAllIntevals(intervals);
        
        for(int[] val : res) {
            System.out.println(val[0] + ", " + val[1]);
        }
    }
    
    public static int[][] mergeAllIntevals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        //Arrays.sort(points, Comparator.comparingDouble(o -> o[0]));
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for(int[]interval : intervals) {
            if(list.isEmpty() || interval[0]>list.getLast()[1]) {
                list.add(interval);
            } else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }
        
        return list.toArray(new int[list.size()][]);
        
    }
}
