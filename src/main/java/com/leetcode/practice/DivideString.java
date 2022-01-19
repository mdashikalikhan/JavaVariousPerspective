package com.leetcode.practice;

import java.util.Arrays;

public class DivideString {
	
	public static void main(String[] args) {
		System.out.println( Arrays.toString(divideString("ctoyjrwtngqwt",
				8,
				'n')));
		
	}
	
	public static String[] divideString(String s, int k, char fill) {
        int len = s.length()/k + (s.length()%k==0?0:1);
        String[] arr = new String[len];
        int pos = 0;
        for(int i =0; i<len;i++){
        	if(pos+k<=s.length()) {
        		arr[i] = s.substring(pos, pos+k);
        	} else {
        		int remaining = pos+k-s.length();
        		String remainStr = (fill+"").repeat(remaining);
        		arr[i] = s.substring(pos, s.length()) + remainStr;
        	}
        	
            pos = pos + k;
            
        }
        
        return arr;
    }
}
