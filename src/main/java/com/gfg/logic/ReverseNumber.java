package com.gfg.logic;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(reverseDigit(-1000000045));
	}
	
	static int reverseDigit(int number) {
		boolean negativeFlag = false;
		int reverseNumber = 0, previousReverseNumber = 0;
		if(number<0) {
			negativeFlag = true;
			number = -number;
		}
		
		while(number>0) {
			int currentDigit = number % 10;
			reverseNumber = reverseNumber * 10 + currentDigit;
			
			if((reverseNumber-currentDigit)/10 != previousReverseNumber) {
				System.out.println("OVERFLOWED!!!!");
				return 0;
			}
			
			previousReverseNumber = reverseNumber;
			
			number = number / 10;
		}
		
		
		if(negativeFlag==true) {
			reverseNumber = -reverseNumber;
		}
		return reverseNumber;
		
		
	}

}
