package com.practice;

public class FlagsSample {
	public static void main(String[] args) {
		int[] A= {0, 0, 0, 0, 0, 1, 0, 1, 0, 1};/*{1,5,3,4,3,4,1,2,3,4,6,2};*/
		System.out.println(solution(A));
		boolean[] peaks = buildPeaks(A);
		for(boolean p: peaks) {
			System.out.print(p + " ");
		}
		System.out.println();
		
		int[] nextPeaks = buildNextPeaks(peaks);
		for(int next : nextPeaks) {
			System.out.print(next + " ");
		}
		System.out.println();
		int maxFlag = 0;
		for(int i=1; i*i<=A.length; i++) {
			boolean res = canSetFlag(nextPeaks, i);
			if(res==false) {
				break;
			}
			maxFlag = i;
		}
		System.out.println(maxFlag);
	}
	
	static boolean[] buildPeaks(int[] A) {
		boolean peaks[] = new boolean[A.length];
		
		for(int i=1; i<A.length-1; i++) {
			if(A[i-1]<A[i] && A[i] > A[i+1]) {
				peaks[i] = true;
			}
		}
		
		return peaks;
	}
	
	static int[] buildNextPeaks(boolean[] peaks) {
		int[] nextPeaks = new int[peaks.length];
		int next = -1;
		for(int i = peaks.length-1; i>=0; i--) {
			if(peaks[i]) {
				next = i;
			}
			nextPeaks[i] = next;
		}
		return nextPeaks;
	}
	
	static boolean canSetFlag(int[] nextPeaks, int flag) {
		int index = 0;
		for(int i=0; i<flag; i++) {
			if(index>=nextPeaks.length || nextPeaks[index]<0) {
				return false;
			}
			index = nextPeaks[index] + flag; 
		}
		return true;
	}
	
	 static public int solution(int[] A) {
	        int n = A.length;
	        boolean[] peaks = new boolean[n]; 
	        int[] nextPeaks = new int[n];
	        for(int i =1; i<n-1; i++){
	            if(A[i]>A[i-1] && A[i]>A[i+1]){
	                peaks[i] = true;
	            }
	        }
	        
	        int next = -1;
	        for(int i=n-1; i>=0; i--){
	            if(peaks[i]==true){
	                next = i;
	            }
	            nextPeaks[i] = next;
	        }
	        
	        for(int i : nextPeaks) {
				System.out.print(i + " ");
			}
			System.out.println();
	        
	        int maxFlag = 0;
	        
	        for(int i=1; i*i<=n; i++){
	            boolean check = true;
	            
	            int index = 0;
	            for(int j=0; j<i; j++){
	                if(index>n || nextPeaks[index]<0){
	                    check = false;
	                    break;
	                }
	                index = nextPeaks[index] + i;
	            }
	            if(check==false){
	                break;
	            }
	            maxFlag = i;
	        }
	        
	        return maxFlag;
	    }
}
