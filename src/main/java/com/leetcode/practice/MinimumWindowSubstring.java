package com.leetcode.practice;

import java.util.HashMap;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		MinimumWindowSubstring min = new MinimumWindowSubstring();
		System.out.println(min.minWindow("ADOBECODEBANC", "ABBC"));
	}
	
	public String minWindow(String s, String t) {

		HashMap<Character, Integer> occurrences = new HashMap<>();

		HashMap<Character, Integer> rOccurrences = new HashMap<>();

		int totalNeed = 0;
		for ( char c : t.toCharArray() ) {
			occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
			totalNeed += 1;
		}

		int windowStart = 0;

		int matched = 0;

		int minLen = Integer.MAX_VALUE;

		String result = "";

		for ( int windowEnd = 0; windowEnd < s.length(); windowEnd++ ) {
			char current = s.charAt(windowEnd);
			if (occurrences.containsKey(current)) {
				rOccurrences.put(current, rOccurrences.getOrDefault(current, 0) + 1);
				if (rOccurrences.get(current) <= occurrences.get(current)) {
					matched++;
				}
			}

			if (matched == totalNeed) {
				if (windowEnd - windowStart + 1 < minLen) {
					minLen = windowEnd - windowStart + 1;
					result = s.substring(windowStart, windowEnd + 1);
				}

				while (true) {
					char firstChar = s.charAt(windowStart);
					if (rOccurrences.getOrDefault(firstChar, 0) > 0) {
						if (rOccurrences.get(firstChar) == occurrences.get(firstChar)) {
							matched--;
							rOccurrences.put(firstChar, rOccurrences.get(firstChar) - 1);
							windowStart++;
							break;
						}
						rOccurrences.put(firstChar, rOccurrences.get(firstChar) - 1);
					}
					windowStart++;
				}
			}

		}

		return result;
	}
}
