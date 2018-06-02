package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ClimbingLaderboard {
	static int[] climbingLeaderboard(int[] scores, int[] alice, Map<Integer, Integer> scoresMap) {
		int[] alicePosition = new int[alice.length];
		Set<Integer> keys = scoresMap.keySet();
		Integer[] distinctScores = keys.toArray(new Integer[keys.size()]);
		Arrays.sort(distinctScores, Collections.reverseOrder());
		int index = 0;

		for (int aliceScore : alice) {
			Integer position = scoresMap.get(aliceScore);
			System.out.println("aliceScore~~" + aliceScore);
			if (position != null) {
				alicePosition[index++] = position;
			} else if (aliceScore > distinctScores[0]) {
				alicePosition[index++] = 1;
			} else if (aliceScore < distinctScores[distinctScores.length - 1]) {
				alicePosition[index++] = scoresMap.get(distinctScores[distinctScores.length - 1]) + 1;
			} else {
				System.out.println(aliceScore + "1~~" + binarySearch(distinctScores, aliceScore) + "~~"
						+ (scoresMap.get(distinctScores[binarySearch(distinctScores, aliceScore)])) );
				alicePosition[index++] = scoresMap.get(distinctScores[binarySearch(distinctScores, aliceScore)]);
			}
		}
		
		for(int val : alicePosition) {
			System.out.println(val);
		}
		return alicePosition;

	}

	static int binarySearch(Integer[] inputArr, int key) {

		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key < inputArr[mid]) {
				start = mid + 1;

			} else {
				end = mid - 1;
			}
			/*System.out.println(start + "~~" + end);*/
		}
		return Math.max(start, end);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int scoresCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] scores = new int[scoresCount];

		String[] scoresItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		Map<Integer, Integer> scoresMap = new HashMap<Integer, Integer>();

		int pos = 0;
		for (int i = 0; i < scoresCount; i++) {
			int scoresItem = Integer.parseInt(scoresItems[i]);
			scores[i] = scoresItem;
			if ((i == 0) || (i > 0 && scores[i] != scores[i - 1])) {
				scoresMap.put(scores[i], ++pos);
			}

		}

		int aliceCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] alice = new int[aliceCount];

		String[] aliceItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < aliceCount; i++) {
			int aliceItem = Integer.parseInt(aliceItems[i]);
			alice[i] = aliceItem;
		}

		int[] result = climbingLeaderboard(scores, alice, scoresMap);

		scanner.close();
	}
}
