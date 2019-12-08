package com.practice;

public class MaxProductOfThree {

	public static void main(String[] args) {
		int A[] = {-3, 1, 2, -2, 5, 6};
		int firstHighest = A[0];
        int secondHighest = A[1];
        int thirdHighest = A[2];
        
        if(firstHighest < secondHighest){
            firstHighest = firstHighest ^ secondHighest;
            secondHighest = firstHighest ^ secondHighest;
            firstHighest = firstHighest ^ secondHighest;
        }
        
        if(secondHighest < thirdHighest){
            secondHighest = thirdHighest ^ secondHighest;
            thirdHighest = thirdHighest ^ secondHighest;
            secondHighest = thirdHighest ^ secondHighest;
        }
        
        if(firstHighest < secondHighest){
            firstHighest = firstHighest ^ secondHighest;
            secondHighest = firstHighest ^ secondHighest;
            firstHighest = firstHighest ^ secondHighest;
        }
        
        for(int i = 3; i<A.length; i++){
            if(A[i]>firstHighest){
                thirdHighest = secondHighest;
                
                secondHighest = firstHighest;
                
                firstHighest = A[i];
            } else if(A[i]>secondHighest){
                thirdHighest = secondHighest;
                secondHighest = A[i];
            } else if(A[i]>thirdHighest){
                thirdHighest = A[i];
            }
        }
        System.out.println(firstHighest);
        System.out.println(secondHighest);
        System.out.println(thirdHighest);
	}

}
