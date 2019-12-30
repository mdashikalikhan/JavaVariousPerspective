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
        int[] c = {0,0,0,1,0,0};
        System.out.println(jumpingOnClouds(c));
	}
	
	static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        for (int i=0; i<c.length; ){

            if(i==(c.length-1)){
            	i++;
                continue;
            }

            if(((i+2) < c.length ) && (c[i+2]==0)){
                jumps++;
                i= i + 2;
            } else if( ((i+1) < c.length) && (c[i+1]==0)){
                jumps++;
                i= i + 1;
            }
        }
        return jumps;

    }

}
