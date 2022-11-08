package com.leetcode.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountVowelsOfAllSubstrings {
    public static void main(String[] args) {
        String word = "axybcain";

        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u')) ;
        
        int l = word.length();
        int total = 0;
        for(int i=0; i<word.length(); i++){
            if(vowelSet.contains(word.charAt(i))){
                total += (l-i) * (i+1);
            }
        }
    
        System.out.println(total);
    }
}
