package com.practice;

import java.util.Stack;

public class Fish {

	public static void main(String[] args) {
		int[] A = {4,3,2,1,5};
		int[] B= {0,1,0,1,0};
		
		Stack<Integer> downStream = new Stack<>();
		Stack<Integer> upStream = new Stack<>();
		
		for(int i=0; i<A.length; i++) {
			if(B[i]==0) {
				upStream.push(A[i]);
				
				while(downStream.size()>0) {
					if(A[i]>downStream.peek()) {
						downStream.pop();
					}else {
						upStream.pop();
						break;
					}
				}
				
			} else {
				downStream.push(A[i]);
			}
		}
		
		
		for(int i=0; i<downStream.size();i++) {
			System.out.println("downstream: " + downStream.get(i));
		}
		
		for(int i=0; i<upStream.size();i++) {
			System.out.println("upStream: " + upStream.get(i));
		}
		System.out.println(downStream.size() + upStream.size());
	}

}
