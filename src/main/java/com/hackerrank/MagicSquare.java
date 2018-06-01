package com.hackerrank;
public class MagicSquare {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 4 }, { 5, 6 } };

		int[][] magicSquareArray = { { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
				{ 6, 1, 8, 7, 5, 3, 2, 9, 4 }, { 2, 7, 6, 9, 5, 1, 4, 3, 8 },
				{ 4, 3, 8, 9, 5, 1, 2, 7, 6 }, { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
				{ 4, 9, 2, 3, 5, 7, 8, 1, 6 }, { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
				{ 8, 3, 4, 1, 5, 9, 6, 7, 2 } };
		for (int[] ar : magicSquareArray) {
			for (int element : ar) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	static int formingMagicSquare(int[][] s) {

		int minimumCost = -1;
		int[][] magicSquareArray = { { 8, 1, 6, 3, 5, 7, 4, 9, 2 },
				{ 6, 1, 8, 7, 5, 3, 2, 9, 4 }, { 2, 7, 6, 9, 5, 1, 4, 3, 8 },
				{ 4, 3, 8, 9, 5, 1, 2, 7, 6 }, { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
				{ 4, 9, 2, 3, 5, 7, 8, 1, 6 }, { 6, 7, 2, 1, 5, 9, 8, 3, 4 },
				{ 8, 3, 4, 1, 5, 9, 6, 7, 2 } };
		for (int[] square : magicSquareArray) {
			int cost = Math.abs(square[0] - s[0][0])
					+ Math.abs(square[1] - s[0][1])
					+ Math.abs(square[2] - s[0][2]);
			cost += Math.abs(square[3] - s[1][0])
					+ Math.abs(square[4] - s[1][1])
					+ Math.abs(square[5] - s[1][2]);
			cost += Math.abs(square[6] - s[2][0])
					+ Math.abs(square[7] - s[2][1])
					+ Math.abs(square[8] - s[2][2]);
			if (minimumCost == -1) {
				minimumCost = cost;
			} else if (cost < minimumCost) {
				minimumCost = cost;
			}
		}
		return minimumCost;

	}
}
