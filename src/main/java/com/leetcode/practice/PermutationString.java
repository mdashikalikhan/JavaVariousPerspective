package com.leetcode.practice;

import java.util.Arrays;

public class PermutationString {
	public static void main(String[] args) {
		System.out.println(checkInclusion("abc","dcba"));
	}
	public static boolean checkInclusion(String s1, String s2) {
        boolean b = false;
        
        int k = s1.length()-1;
        System.out.println(k);
        
        int charArray[] = new int[27];
        
        Arrays.fill(charArray, 0);
        
        for(int i=0; i<s1.length(); i++){
            charArray[s1.charAt(i)-96]++;
            
        }
        
        int t[] = new int[27];
        Arrays.fill(t, 0);
        
        for(int i=0; i<s2.length(); i++){
            
            int c = s2.charAt(i) - 96;
            t[c]++;
            System.out.println((i-k));
            if(i-k>=0){
                
                if(subtractArray(charArray, t)==0)
                {
                    b = true;
                    break;
                }
                int removeIdx = s2.charAt(i-k) - 96;
                t[removeIdx]--;
            } 
        }
        
        return b;
    }
    
    public static int subtractArray(int[] charArray, int[] t){
        int sub = 0;
        for(int i=1; i<=26; i++){
            if(charArray[i]!=t[i]) {
            	sub = 1;
            	break;
            }
        }
        System.out.println(Arrays.toString(charArray));
        System.out.println(Arrays.toString(t));
        System.out.println(sub);
        return sub;
    }
}
