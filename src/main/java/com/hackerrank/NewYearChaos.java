package com.hackerrank;

public class NewYearChaos {

	public static void main(String[] args) {
		int q[] = {1, 2, 5, 3, 7, 8, 6, 4} /*{2, 5, 1, 3, 4}*/ /*{2, 1, 5, 3, 4}*/;
		
		long noOfBribes = 0;
		
		
		for(int i = q.length-1; i>=0; i--) {
			int currentPos = i + 1;
			
			if(q[i] == currentPos) {
				continue;
			}
			
			if(q[i-1] == currentPos) {
				noOfBribes+=1;
				q[i-1] = q[i];
				q[i] = currentPos;
				
			} else if(q[i-2] == currentPos) {
				noOfBribes+=2;
				q[i-2] = q[i-1];
				q[i-1] = q[i];
				q[i] = currentPos;
			} else {
				System.out.println("Too chaotic");
				return;
			}
			
		}
		
		

        System.out.println(noOfBribes);
	}

}
