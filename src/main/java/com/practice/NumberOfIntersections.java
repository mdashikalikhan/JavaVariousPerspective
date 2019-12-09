package com.practice;

import java.util.Arrays;

public class NumberOfIntersections {

	public static void main(String[] args) {
		int A[] = { 1, 5, 2, 1, 4, 0 };
		
		NumberOfIntersections ans = new NumberOfIntersections();
		System.out.println(ans.solution(A)); 
		int startpoint[] = new int[A.length];
		int endpoint[] = new int[A.length];
		int open = 0;
		int intersections = 0;

		for (int i = 0; i < A.length; i++) {
			startpoint[i] = i - A[i];
			endpoint[i] = i + A[i];
		}

		Arrays.sort(startpoint);
		Arrays.sort(endpoint);

		int pop = 0;

		for (int i = 0; i < A.length; i++) {
			System.out.print(startpoint[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.print(endpoint[i] + " ");
		}

		System.out.println();

		/*int[] positions = new int[A.length * 2];
		int[] posOpen = new int[A.length * 2];
		int[] posClose = new int[A.length * 2];

		int i = 0, j = 0, k = 0;

		while (i < A.length && j < A.length) {
			if (startpoint[i] < endpoint[j]) {
				positions[k] = startpoint[i++];
				++posOpen[k++];
			} else {
				positions[k] = endpoint[j++];
				++posClose[k++];
			}
		}

		while (i < A.length) {
			positions[k] = startpoint[i++];
			++posOpen[k++];
		}

		while (j < A.length) {
			positions[k] = endpoint[j++];
			++posClose[k++];
		}

		for (int c = 0; c < positions.length; c++) {
			System.out.print(positions[c] + " ");
		}

		System.out.println();
		System.out.println("Open Positions");
		for (int c = 0; c < positions.length; c++) {
			System.out.print(posOpen[c] + " ");
		}

		System.out.println();
		System.out.println("Close Positions");
		for (int c = 0; c < positions.length; c++) {
			System.out.print(posClose[c] + " ");
		}

		System.out.println();
		System.out.println(i);
		System.out.println(j);*/

		/*
		 * for(int i=0; i<A.length; i++) { if(startpoint[i]<=endpoint[pop]) { open++; }
		 * 
		 * if(startpoint[i]>endpoint[pop]) {
		 * 
		 * }
		 * 
		 * if(i!=0 && open>0) { intersections += open; } }
		 * 
		 * System.out.println(intersections);
		 */
	}

	public int solution(int[] A) {
		final int N = A.length;

		if (N < 2) {
			return 0;
		}

		long[] leftEdges = new long[N];
		long[] rightEdges = new long[N];

		for (int i = 0; i < N; i++) {
			long r = (long) A[i];

			long left = i - r;
			leftEdges[i] = left;

			long right = i + r;
			rightEdges[i] = right;
		}

		quicksort(leftEdges, 0, N - 1);
		quicksort(rightEdges, 0, N - 1);

		for (int i = 0; i < N; i++) {
			System.out.print(leftEdges[i] + " ");
		}
		System.out.println();
		
		for (int i = 0; i < N; i++) {
			System.out.print(rightEdges[i] + " ");
		}
		System.out.println();
		
		int counter = 0;
		int previousCircles = 0;
		int leftP = 0;

		for (int rightP = 0; rightP < N; rightP++) {
			System.out.println("1. rightP: " +rightP );
			while ((leftP < N) && (leftEdges[leftP] <= rightEdges[rightP])) {
				leftP++;
				previousCircles++;
				System.out.println("2. leftP: " +leftP );
				System.out.println("3. previousCircles: " +previousCircles );
			}

			counter += --previousCircles;
			System.out.println("4. counter: " +counter );
			System.out.println("5. previousCircles: " +previousCircles );
			System.out.println("6. rightEdges["+rightP+"]: " +rightEdges[rightP]
					+ "     " + "counter: " + counter);

			if (counter > 10000000) {
				return -1;
			}
		}
		return counter;
	}

	private void quicksort(long arr[], int left, int right) {
		int index = partition(arr, left, right);

		if (left < index - 1) {
			quicksort(arr, left, index - 1);
		}

		if (index < right) {
			quicksort(arr, index, right);
		}
	}

	private int partition(long arr[], int left, int right) {
		long pivot = arr[(left + right) / 2];

		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				long tmp = arr[left];
				arr[left++] = arr[right];
				arr[right--] = tmp;
			}
		}

		return left;
	}

}
