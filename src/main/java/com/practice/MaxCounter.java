package com.practice;

import java.util.Arrays;

public class MaxCounter {

	public static void main(String[] args) {
		int[] output = solution(5, new int[] {3,4,4,6,1,4,4});
		for(int i: output) {
			System.out.println(i);
		}
	}
	
	static int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        for(int i=0; i<N; i++){
            counter[i]=0;
        }
        
        int maxValue = 0;
        int maxCounter = 0;
        
        
        
        for(int i=0; i<A.length; i++){
            
            
            
            if(A[i]<=N && A[i]>0){
                
                if(counter[A[i]-1] < maxCounter){
                    counter[A[i]-1] = maxCounter + 1;
                } else {
                    counter[A[i]-1]++;
                }
                
                if(maxValue < counter[A[i]-1]){
                    maxValue = counter[A[i]-1]; 
                }
                
            } else if(A[i] > N){
                maxCounter = maxValue;
                
            }
        }
        
        for(int i=0; i<N; i++){
            if(counter[i] < maxCounter){
                counter[i] = maxCounter;
            }
            
        }
        
        return counter;
    }

}
