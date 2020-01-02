package com.practice;

public class NextGreaterPermutation {

	/**
	 * 
	 * @param args
	 * 
	 * It's also the hackerrank solution of Bigger is Greater
	 * Algorithm:
	 * 
	 * 1. Find highest index i such that A[i] < A[i+1] if such i is not present then this is the last permutation
	 * 
	 * 2. Find the highest j > i such that A[j] > A[i]. such a j must exist because i+1 is such a j.
	 * 
	 * 3. Swap A[j] and A[i]
	 * 
	 * 4. Reverse the order of all element after i index till the last element.
	 *   
	 */
	public static void main(String[] args) {
		String w = "0125330" /*"ab"*/;
		
		int i = -1;
		for(int index=w.length()-1; index>0; index--) {
			if(w.charAt(index) > w.charAt(index-1) ) {
				i = index-1;
				break;
			}
		}
		
		if(i==-1) {
			System.out.println("NO");
			return;
		}
		
		int j = w.length()-1;
		
		while(w.charAt(j) <= w.charAt(i)) {
			j--;
		}
		
		char[] chars = w.toCharArray();
		char t = chars[i];
		chars[i] = chars[j];
		chars[j] = t;
		
		for(int index1 = i + 1, index2 = w.length()-1; index1 < index2 ; index1++, index2-- ) {
			t = chars[index1];
			chars[index1] = chars[index2];
			chars[index2] = t;
		}

		w="";
		for(char c : chars) {
			w+=c;
		}
		
		System.out.println(w);
		
		
		
		

	}

}
