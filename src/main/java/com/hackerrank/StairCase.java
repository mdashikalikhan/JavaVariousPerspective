package com.hackerrank;

import java.util.Arrays;

public class StairCase {
	static void staircase(int n) {

		char[] spaces = new char[n];
		Arrays.fill(spaces, ' ');

		char[] stars = new char[n];
		Arrays.fill(stars, '#');

		StringBuffer buffer = new StringBuffer();

		for (int stage = 1; stage <= n; stage++) {
			buffer.delete(0, buffer.length());
			buffer.insert(0, spaces, 0, (n - stage));
			System.out.print(buffer);

			buffer.delete(0, buffer.length());
			buffer.insert(0, stars, 0, stage);
			System.out.print(buffer);

			if (stage != n) {
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		staircase(10);
		int[] st = { 2, 2, 1, 3, 2, 0 };
		solve(6, st, 5, 3);
		System.out.println(solve(5, st, 4, 2));
	}

	static int solve(int n, int[] s, int d, int m) {

		int sum = 0;
		int ways = 0;
		int pos = 0;

		for(int square : s) {
			if(m>1) {
				pos++;
				sum += square;
			}
			
			if (pos == m) {
				if (d == sum) {
					ways++;
				}
				sum = square;
				pos = 1;
			}
		}
		
		return ways;
	}
}
