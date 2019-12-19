package com.practice;

import java.util.ArrayList;
import java.util.List;

public class Peaks {

	public static void main(String[] args) {
		int[] A = {1,2,3,4,3,4,1,2,3,4,6,2};
		
		List<Integer> p = new ArrayList<>();
		
		for(int i=1; i<A.length-1; i++) {
			if(A[i]>A[i-1] && A[i]>A[i+1]) {
				p.add(i);
			}
		}
		
		for(int idx : p) {
			System.out.print(idx + " ");
		}
		System.out.println();
		
		for(int i=1; i<=A.length; i++) {
			if(A.length%i!=0) {
				continue;
			}
			System.out.println(i);
			int groups = A.length / i;
			int find = 0;
			
			for(int idx : p) {
				if(idx/i > find) {
					break;
				}
				if(idx/i==find) {
					find++;
				}
				
				
			}
			System.out.println("find: " + find + " i: " + i + " groups: " + groups);
			
		}
		
	}

}
