package com.practice;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		int a[] = { 4, 2, 2, 5, 1, 5, 8 };

		int minIDx = 0;

		double minAvg = ((double) (a[0] + a[1])) / 2;

		double curAvg;
		System.out.println(minAvg);
		for (int i = 0; i < a.length - 2; i++) {
			curAvg = ((double) (a[i] + a[i + 1] + a[i + 2])) / 3;

			if (curAvg < minAvg) {
				minIDx = i;
				minAvg = curAvg;

			}
			System.out.println(minAvg);
			curAvg = ((double) (a[i] + a[i + 1] )) / 2;

			if (curAvg < minAvg) {
				minIDx = i;
				minAvg = curAvg;

			}
			System.out.println(minAvg);
		}
		
		curAvg = ((double) (a[a.length-1] + a[a.length-2] )) / 2;

		if (curAvg < minAvg) {
			minIDx = a.length-1;
			minAvg = curAvg;

		}
		System.out.println(minAvg);
		System.out.println(minIDx);
	}

}
