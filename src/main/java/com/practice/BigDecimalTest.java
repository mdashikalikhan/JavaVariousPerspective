package com.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {
	public static void main(String[] args) {
		/*BigDecimal amount = new BigDecimal( 12233124.533432);
		BigDecimal factor = new BigDecimal(100000);
		amount = amount.divide(factor);
		System.out.println(amount);
		amount = amount.multiply(factor);
		System.out.println(amount);
		
		BigDecimal val1 = new BigDecimal(2165321.42363587);
		
		System.out.println(val1.setScale(3, BigDecimal.ROUND_UP));
		System.out.println(val1.setScale(2, BigDecimal.ROUND_UP));
		
		System.out.println(val1.setScale(3, BigDecimal.ROUND_HALF_UP));
		System.out.println(val1.setScale(2, BigDecimal.ROUND_HALF_UP));*/
		
		/*bookVal=bookVal.add((arbitrarySelection.getBookValue().divide(arbitrarySelection.getAvailableQuantity())
				.multiply(arbitrarySelection.getUtilizedQuantity())));*/
		
		/*BigDecimal sum = BigDecimal.ZERO;
		BigDecimal bookVal = new BigDecimal("777455560.001");
		
		BigDecimal quantity = new BigDecimal("70000000.878");
		BigDecimal utilized = new BigDecimal("500.01");
		
		sum = sum.add(bookVal).divide(quantity,8, RoundingMode.HALF_UP).multiply(utilized);
		System.out.println(sum);*/
		
		BigDecimal val1 = new BigDecimal("6353545435435");
		BigDecimal val2 = new BigDecimal("6353545435435");
		
		System.out.println(val1.setScale(0, RoundingMode.CEILING));
		
		
	}
}
