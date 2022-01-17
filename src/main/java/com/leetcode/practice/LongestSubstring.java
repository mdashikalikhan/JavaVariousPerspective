package com.leetcode.practice;

import java.util.*;

public class LongestSubstring {
	public static void main(String[] args) {
		String s = "dsvcsdf";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		Set<Character> set = new HashSet<>();
		
		int pos = 0;
		int i = 0;
		
		while(i<s.length()) {
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i));
				if(set.size()>max) {
					max = set.size();
				}
				i++;
			} else {
				set.remove(s.charAt(pos));
				pos++;
			}
		}
		
		return max;
	}
}
