package com.hackerrank;


public class ExtraLongFactorial {
	public static void main(String[] args) {
		factorial(1050);
	}
	
	static void factorial(int n) {
		int factContents[] = new int[1000000];
		int factSize = 1;
		factContents[0] = 1;
		for(int i=2; i<=n; i++){
			factSize = multiply(i, factContents, factSize);
		}
		for(int i = factSize - 1 ; i>=0; i--){
			System.out.print(factContents[i]);
		}
		
	}
	
	static int multiply(int x, int[] factContents, int factSize){
		int carry = 0;
		
		for(int i=0; i<factSize; i++){
			int product = factContents[i] * x + carry;
			factContents[i] = product % 10;
			carry = product/10;
		}
		while(carry!=0){
			factContents[factSize] = carry % 10;
			carry = carry / 10;
			factSize++;
		}
		return factSize;
	}
}
