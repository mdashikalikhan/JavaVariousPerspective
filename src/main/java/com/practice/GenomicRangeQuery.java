package com.practice;

public class GenomicRangeQuery {

	/*
	 * A=1 C=2 G=3 T=4
	 */

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "CAGCCTA";

		int[][] genom = new int[3][s.length() + 1];

		/*
		 * index: 0=A 1=C 2=G
		 */

		for (int i = 0; i < s.length(); i++) {
			int a, c, g;
			a = c = g = 0;

			if (s.charAt(i) == 'A') {
				a = 1;
			} else if (s.charAt(i) == 'C') {
				c = 1;
			} else if (s.charAt(i) == 'G') {
				g = 1;
			}
			
			genom[0][i+1] = genom[0][i] + a;
			genom[1][i+1] = genom[1][i] + c;
			genom[2][i+1] = genom[2][i] + g;
			
		}
		
		for(int i=0; i<3; i++) {
			for(int j=1; j<s.length()+1; j++) {
				System.out.print(genom[i][j] + "  ");
			}
			System.out.println();
		}
		for(int j=0; j<s.length(); j++) {
			System.out.print(s.charAt(j) + "  ");
		}

	}

}
