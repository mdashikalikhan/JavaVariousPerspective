package com.practice;

import java.util.*;

public class EquileaderSolution {
	public int solution(int[] A) {
		int equileader = 0;
		Stack<Integer> stack = new Stack<>();
		int total = 0;

		int leftCount = 0;
		int rightCount = 0;

		for (int i = 0; i < A.length; i++) {
			stack.push(A[i]);

			if (stack.size() > 1) {
				int last = stack.peek();
				int beforeLast = stack.get(stack.size() - 2);

				if (last != beforeLast) {
					stack.pop();
					stack.pop();
				}
			}
		}

		if (stack.size() == 0) {
			return 0;
		}

		int candidate = stack.peek();

		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				total++;
			}
		}

		if (total <= A.length / 2) {
			return 0;
		}

		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				leftCount++;
			}
			rightCount = total - leftCount;
			if ((leftCount > (i + 1) / 2) && (rightCount > (A.length - i - 1) / 2)) {

				equileader++;
			}
		}

		return equileader;
	}
}
