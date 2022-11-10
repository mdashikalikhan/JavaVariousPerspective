package com.leetcode.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNA {
    public static void main(String[] args) {
		String s ="AAAAAAAAAAA";//"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		/*
		 * System.out.println(s.substring(0,10)); System.out.println(s.substring(1,11));
		 */
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		int windowStart = 0;
		int windowEnd = 10;
		for(int i=0;i<s.length(); i++) {
		    if(i<=8) {
		        continue;
		    }
		 if(map.getOrDefault(s.substring(windowStart, windowEnd), 0)==1){
		     list.add(s.substring(windowStart, windowEnd));
		 }
		 map.put(s.substring(windowStart, windowEnd), map.getOrDefault(s.substring(windowStart, windowEnd), 0) + 1);
		 
		 windowStart++;
		 windowEnd++;
		    
		}
		
		System.out.println(list);
	}
}
