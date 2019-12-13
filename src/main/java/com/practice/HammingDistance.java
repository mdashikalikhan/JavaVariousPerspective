package com.practice;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 1, y = 4;
		
		String binaryX = "";
		String binaryY = "";
		
		while(x!=0) {
			binaryX = (x&1) + binaryX;
			x = x>>1;
		}
		
		while(y!=0) {
			binaryY = (y&1) + binaryY;
			y = y>>1;
		}
		
		while(binaryX.length() != binaryY.length()) {
			if(binaryX.length()<binaryY.length()) {
				binaryX = "0" + binaryX;
			}else {
				binaryY = "0" + binaryY;
			}
		}
		
		int hammingDistance = 0;
		
		for(int i=0; i<binaryX.length(); i++) {
			if(binaryX.charAt(i)!=binaryY.charAt(i)) {
				hammingDistance++;
			}
		}
		
		System.out.println(binaryX);
		System.out.println(binaryY);
		System.out.println(hammingDistance);
		
		System.out.println(4&1);
		
	}

}
