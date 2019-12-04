package com.practice;

public class BinaryGap {

	public static void main(String[] args) {
		int n = 2147483647;
		int currentGap = -1;
		int longestGap = 0;

		while (n != 0) {
			System.out.println(n & 1);
			if ((n & 1) == 0 && currentGap != -1) {
				currentGap++;
			} else if((n&1)==1){
				longestGap = currentGap > longestGap ? currentGap : longestGap;
				currentGap = 0;
			}
			n = n >> 1;
		}

		System.out.println("longestGap: " + longestGap);

		System.out.println("Solution: " + solution(144));
	}

	static int solution(int N) {
		int longestBinaryGap = 0;
		int currentBinaryGap = -1;

		int val = N;

		while (val != 0) {
			if ((val & 1) == 1) {
				if (longestBinaryGap < currentBinaryGap) {
					longestBinaryGap = currentBinaryGap;
				}

				currentBinaryGap = 0;
			} else if (currentBinaryGap != -1) {
				++currentBinaryGap;
			}

			val = val >> 1;
		}

		return longestBinaryGap;
	}

}
