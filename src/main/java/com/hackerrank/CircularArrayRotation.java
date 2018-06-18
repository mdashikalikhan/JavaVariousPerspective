package com.hackerrank;

public class CircularArrayRotation {

	public static void main(String[] args) {
		int[] a = { 39356, 87674, 16667, 54260, 43958, 70429, 53682, 6169,
				87496, 66190, 90286, 4912, 44792, 65142, 36183, 43856, 77633,
				38902, 1407, 88185, 80399, 72940, 97555, 23941, 96271, 49288,
				27021, 32032, 75662, 69161, 33581, 15017, 56835, 66599, 69277,
				17144, 37027, 39310, 23312, 24523, 5499, 13597, 45786, 66642,
				95090, 98320, 26849, 72722, 37221, 28255, 60906 };
		int idx = 0;
		for (int val : circularArrayRotation(a, 51)) {
			System.out.println("Index " + (idx) + ": " + val);
			idx++;
		}

	}

	static int[] circularArrayRotation(int[] a, int k) {
		int[] rotateArray = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			rotateArray[(i+k)%a.length] = a[i];
		}

		return rotateArray;

	}

}
