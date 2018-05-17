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
			
			if(stage!=n) {
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		staircase(10);
	}
}
