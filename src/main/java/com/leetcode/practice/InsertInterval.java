package com.leetcode.practice;

import java.util.*;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = /*{{2, 6},{7, 9}};*/ {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = /*{15, 18};*/ {4,8};
        intervals = insert(intervals, newInterval);
        for(int[] interval : intervals) {
            System.out.println(interval[0] + "  " + interval[1]);
        }
    }
    
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(); 
        list.add(newInterval);
        for(int[] interval : intervals) {
            
            if(interval[0]>list.get(list.size()-1)[1]) {
                list.add(interval);
            } else if(list.get(list.size()-1)[0]>interval[1]) {
                int [] t = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(interval);
                list.add(t);
            } else {
                list.get(list.size()-1)[0] = Math.min(list.get(list.size()-1)[0], interval[0]);
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], interval[1]);
            }
            
        }
        
        intervals = list.toArray(new int[list.size()][]);
        return intervals;
    }
}
