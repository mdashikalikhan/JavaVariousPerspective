package com.practice;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal amount = new BigDecimal( 12233124.533432);
		BigDecimal factor = new BigDecimal(100000);
		amount = amount.divide(factor);
		System.out.println(amount);
		amount = amount.multiply(factor);
		System.out.println(amount);
		
		BigDecimal val1 = new BigDecimal(2165321.42363587);
		
		System.out.println(val1.setScale(3, BigDecimal.ROUND_UP));
		System.out.println(val1.setScale(2, BigDecimal.ROUND_UP));
		
		System.out.println(val1.setScale(3, BigDecimal.ROUND_HALF_UP));
		System.out.println(val1.setScale(2, BigDecimal.ROUND_HALF_UP));
	}
}
