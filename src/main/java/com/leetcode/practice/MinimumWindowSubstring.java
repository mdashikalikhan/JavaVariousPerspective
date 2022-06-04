package com.leetcode.practice;

import java.util.HashMap;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		MinimumWindowSubstring min = new MinimumWindowSubstring();
		System.out.println(min.minWindow("ADOBECODEBANC", "ABBC"));
	}
	
	public String minWindow(String s, String t) {

		HashMap<Character, Integer> occurrences = new HashMap<>();


		
		for ( char c : t.toCharArray() ) {
			occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
		}

		int windowStart = 0;

		int matched = 0;

		int minLen = Integer.MAX_VALUE;
		
		int substrStart = 0;


		for(int windowEnd=0; windowEnd<s.length(); windowEnd++) {
			char current = s.charAt(windowEnd);
			
			if(occurrences.containsKey(current)) {
				occurrences.put(current, occurrences.get(current) - 1);
				if(occurrences.get(current)>=0) {
					matched++;
				}
			}
			
			while(matched==t.length()) {
				if(windowEnd-windowStart+1<minLen) {
					minLen = windowEnd - windowStart + 1;
					substrStart = windowStart;
				}
				System.out.println(occurrences);
				System.out.println(windowStart + "   "  + windowEnd);
				char startChar = s.charAt(windowStart);
				
				if(occurrences.containsKey(startChar)) {
					if(occurrences.get(startChar)==0) {
						matched--;
					}
					
					occurrences.put(startChar, occurrences.get(startChar) + 1);
					
				}
				
				windowStart++;
				
			}
			
		}
		

		

		return minLen==Integer.MAX_VALUE ? "" : s.substring(substrStart, substrStart+minLen);
	}
}
