package com.practice;

import java.util.*;

public class SherlockAndAnagrams {

	public static void main(String[] args) {
		String s = "abcd"/*"ifailuhkqq"*/;
		Map<String, Integer> mapCountString = new HashMap<String, Integer>();
		
		//Arrays.sort(s.toCharArray());
		
		int maxRepeat = 0;
		
		int[] occurences = new int[26];
		
		if(s.length()==1) {
			return;
		}
		
		
		for(int i=0; i<s.length(); i++) {
			occurences[s.charAt(i)-97]++;
			if(occurences[s.charAt(i)-97]>maxRepeat) {
				maxRepeat = occurences[s.charAt(i)-97];
			}
			
		}
		
		if(maxRepeat==1) {
			return;
		}
		
		List<String> listString = new ArrayList<>();
		
		for(int i=0; i<s.length(); i++) {
			for(int j=i+1; j<=s.length(); j++) {
				listString.add(s.substring(i, j));
			}
		}
		
		System.out.println(listString);
		
		for(String t : listString) {
			char[] cArray = t.toCharArray();
			Arrays.sort(cArray);
			t = "";
			for(int i=0; i<cArray.length; i++) {
				t += cArray[i];
			}
			
			Integer count = mapCountString.get(t);
			count = (count==null) ? 1 : count + 1;
			
			mapCountString.put(t, count);
			
		}
		
		System.out.println(mapCountString);
		
		int sum = 0;
		
		for( Map.Entry<String, Integer> mapEntry : mapCountString.entrySet()) {
			sum += (mapEntry.getValue() * (mapEntry.getValue()-1))/2;
		}
		
		System.out.println(sum);
	}

}
