package com.hackerrank;

public class HourGlassSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = new int[][] {
				{1, -1 ,0 ,-9, -2 ,-2},
				{-2, -1 ,-6 ,-8, -2, -5},
				{-1, -1 ,-1 ,-2 ,-3, -4},
				{-1 ,-9 ,-2, -4, -4, -5},
				{-7, -3 ,-3 ,-2 ,-9, -9},
				{-1, -3 ,-1, -2 ,-4, -5}};
		/*for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}*/
		System.out.println("Finally " + hourglassSum(arr));
		//System.out.println(-4<-6);
	}
	static int hourglassSum(int[][] arr) {
        int sum = 0;
        for(int i = 0; i<4; i++) {
            for(int j=0; j<4; j++) {
                int tmpSum = arr[i][j+0] + arr[i][j+1]
                            + arr[i][j+2] +  arr[i+1][j+1]
                            + arr[i+2][j+0] + arr[i+2][j+1]
                            + arr[i+2][j+2];
                System.out.println("tmpSum = " + tmpSum);
                if(i==0 && j==0 || sum < tmpSum) {
                    sum = tmpSum;
                    System.out.println("i = " + i  + " sum = " + sum);
                } 
            }
        }    
        return sum;

    }

}
