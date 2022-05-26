package com.leetcode.practice;

public class RegularExpressionMatching {
	private void miain() {
		// TODO Auto-generated method stub

	}
	public static boolean isMatch(String s, String p) {
		
		int pos=0;
		int rule = 0;
		
		int allowAnychar = 0;
		String precedingPredicate = "";
		boolean nextRule = false;
		
		while(rule<p.length()) {
			if(p.charAt(rule)=='.') {
				allowAnychar = 1;
			} else {
				allowAnychar = 0;
			}
		}
		
        return true;
    }
}
