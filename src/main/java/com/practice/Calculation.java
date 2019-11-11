package com.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculation {

	public Calculation() {

	}

	public static void main(String[] args) {
		/*long noOfDays = 1;

		BigDecimal rate = new BigDecimal(1.2);
		BigDecimal principalAmpount = new BigDecimal(2000);
		BigDecimal interestRate = rate.divide(new BigDecimal(100),6, RoundingMode.HALF_UP);

		BigDecimal yearFraction = new BigDecimal(noOfDays).divide(new BigDecimal(360),6, RoundingMode.HALF_UP);

		BigDecimal interestAmount = interestRate.multiply(yearFraction).multiply(principalAmpount);

		System.out.println(interestAmount.setScale(2, RoundingMode.HALF_UP));*/
		
		Object objLoanAmt =  "324324.3254325";
        BigDecimal loanValue = new BigDecimal(objLoanAmt.toString());
        System.out.println(loanValue.toString());
	}

}
