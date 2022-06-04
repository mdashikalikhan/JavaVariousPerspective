package com.educative.twopointer;

import java.util.*;

public class WordConcatenation {
	public static List<Integer> findWordConcatenation(String str, String[] words) {
		List<Integer> resultIndices = new ArrayList<>();
		
		int wordCount = words.length;
		int wordLength = words[0].length();
		
		HashMap<String, Integer> occurrences = new HashMap<>();
		
		for(String w : words) {
			occurrences.put(w, occurrences.getOrDefault(w, 0) + 1);
		}
		
		
		for(int i=0; i<=str.length() - wordCount * wordLength; i++) {
			HashMap<String, Integer> found = new HashMap<>();
			for(int j=0; j<wordCount; j++) {
				String s = str.substring(i+wordLength * j, i+wordLength * j + wordLength);
				if(!occurrences.containsKey(s)) {
					break;
				}
				
				found.put(s, found.getOrDefault(s, 0) + 1);
				
				if(found.get(s)>occurrences.get(s)) {
					break;
				}
				
				if(j==wordCount-1) {
					resultIndices.add(i);
				}
				
				
			}
		}
		
		return resultIndices;
	}
	
	public static void main(String[] args) {
	    List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
	    System.out.println(result);
	    result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
	    System.out.println(result);
	  }
}
