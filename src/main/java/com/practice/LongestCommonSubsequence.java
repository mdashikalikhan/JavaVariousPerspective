package com.practice;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String s1 = "ABCDEF" /*"ABCD"*/ /*"ABCDAF"*/;
		
		String s2 = "FBDAMN" /*"ABDC"*/ /*"ACBCF"*/;
		
		int lcs = 0;
		
		String lcsString = "";
		
		int pos1=0, pos2 = 0;
		
		int[][] t = new int[s2.length()+1][s1.length()+1];
		
		for(int i=1; i<=s2.length(); i++) {
			for(int j=1; j<=s1.length(); j++) {
				if(s1.charAt(j-1)==s2.charAt(i-1)) {
					t[i][j] = t[i-1][j-1]+1;
					if(t[i][j]>lcs) {
						lcs = t[i][j];
						
						pos1 = i;
						pos2 = j;
					}
					
				} else
				{
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		
		System.out.println(lcs);
		System.out.println(pos1 + " " + pos2);
		
		lcsString = "";
		
		while(pos1>0 && pos2 > 0) {
			if((t[pos1][pos2] > t[pos1-1][pos2-1])
					&& (t[pos1][pos2] > t[pos1-1][pos2]) 
					&& (t[pos1][pos2] > t[pos1][pos2-1]) 
					) {
				lcsString = s1.charAt(pos2-1) + lcsString;
				pos1--;
				pos2--;
			} else if(pos2==1) {
				pos1--;
			} else {
				pos2--;
			}
		}
		
		System.out.println(lcsString);
		
	}

}
