package com.practice;

public class OddOccurrences {

	public OddOccurrences() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int A[] = {9,3,9,3,9,7,9};
		int ret = 0 ^ 9 ^ 0 ^ 0;
		
		System.out.println(ret);
		
		ret =  7 ^ 2 ^ 7 ^ 1 ^ 2 ^ 0;
		
		System.out.println(ret);
		ret = 0;
		for(int i : A) {
			ret = ret ^ i;
		}
		System.out.println(ret);

	}

}
