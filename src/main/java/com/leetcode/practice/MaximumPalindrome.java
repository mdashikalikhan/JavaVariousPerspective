package com.leetcode.practice;

import java.util.Arrays;

public class MaximumPalindrome {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String longestPalindorm = "";

        String s = "aaaabbaa";

        //str = "babad";

        //str = "cbbd";

        //str = "abc";

        int [][] dp = new int[s.length()][s.length()];

        for(int i=0; i< s.length(); i++){
            dp[i][i]=1;
            if(i-i+1>longestPalindorm.length()){
                longestPalindorm = s.substring(i, i+1);
            }
            if(i+1<s.length()){
                if(s.charAt(i)==s.charAt(i+1)){
                    dp[i][i+1]=1;
                } else{
                    dp[i][i+1]=0;
                }
                
            }
        }

        for(int i=2; i<s.length(); i++){
            int k = i;
            for(int j=0; j<s.length(); j++){
                if(k>=s.length() || j+1>=s.length()){
                    break;
                }
                if(s.charAt(j)==s.charAt(k)
                && dp[j+1][k-1]==1){
                    dp[j][k] = 1;
                    
                } else {
                    dp[j][k] = 0;
                }
                
                k++;
            }
        }

        for(int i=0; i<s.length(); i++){
            int max = i;
            for(int j=i+1; j<s.length(); j++){
                if(dp[i][j]==1){
                    max = j;
                }
            }

            int palidromeLength = max - i + 1;
            if(longestPalindorm.length()<palidromeLength){
                longestPalindorm = s.substring(i, max + 1);
            }

        }

        
        System.out.println(longestPalindorm);
    }
}
