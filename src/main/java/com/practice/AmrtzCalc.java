package com.practice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class AmrtzCalc {

	public static void main(String[] args) {
		
		System.out.println("HTM: " + calcHTM().setScale(0, RoundingMode.HALF_UP));
		
		double val = 971437604.4;
		System.out.println(val);
		
		BigDecimal bg = new BigDecimal(val);
		System.out.println(bg);
		
		int holdingDays = 7;
		
		String hq = "9000000";
		
		String pv = "838279630.490";
		
		BigDecimal holdingQuantity = new BigDecimal(hq);
		
		BigDecimal pastValue = new BigDecimal(pv);
		
		
		
		BigDecimal bgOfferValue = new BigDecimal(837239400);
		System.out.println("bgOfferValue: " + bgOfferValue);
		
		BigDecimal yd = new BigDecimal( 15.1165);
		
		BigDecimal yield = new BigDecimal(yd.doubleValue()/100);
		System.out.println(yield);
		
		BigDecimal presentValue;
		
		BigDecimal day365 = new BigDecimal(365);
		BigDecimal bgHoldingDays = new BigDecimal(holdingDays);
		
		presentValue = bgOfferValue.add(bgOfferValue.multiply(yield.divide(day365,18, RoundingMode.HALF_UP)).multiply(bgHoldingDays));
		 
		presentValue = presentValue.setScale(0, RoundingMode.HALF_UP);
		
		System.out.println("presentValue: " + presentValue);
		
		System.out.println("pastValue: " + pastValue);
		
		
		BigDecimal holdingUnit = presentValue.subtract(pastValue).divide(holdingQuantity, 18, RoundingMode.HALF_UP);
		
		System.out.println(holdingUnit);
		System.out.println(holdingUnit.doubleValue());
		
		BigDecimal holdingInterest = holdingUnit.multiply(holdingQuantity);
		
		System.out.println(holdingInterest);
		
		BigDecimal a1 = new BigDecimal("10000");
		BigDecimal a2 = new BigDecimal("5");
		
		if(a1.compareTo(a2)==0) {
			System.out.println("equal");
		} else if(a1.compareTo(a2)==-1) {
			System.out.println("less");
		} else if(a1.compareTo(a2)==1) {
			System.out.println("greater");
		}
		
		a2 = a2.setScale(0, RoundingMode.HALF_UP);
		System.out.println(a2);
		
		BigDecimal a3 = new BigDecimal("242344.567");
		System.out.println(a3);
		HashMap map = new HashMap<>();
		map.put("DATA", "0");
		map.put("DATA", "1");
		System.out.println(map.get("DATA"));
		
		BigDecimal a4 = presentValue.subtract(pastValue).divide(holdingQuantity, 18, RoundingMode.HALF_UP).multiply(holdingQuantity);
		System.out.println(a4);
		BigDecimal a5 = new BigDecimal("24324");
		System.out.println(a5.setScale(2, RoundingMode.HALF_UP));
		
		/*
		System.out.println("strawberries".substring(2, 5));
		
		for(int i=0; i<-10; i=i++) {
			i+=1;
			System.out.println("Hello");
		}
		
		System.out.println("apple".compareTo("banana"));*/
		
	}
	
	public static BigDecimal calcHTM() {
		BigDecimal offeredValue = new BigDecimal("1000200000");
		BigDecimal yearFraction=new BigDecimal("0.0767123287671233");
		double y = 19.9953;

		BigDecimal yield=new BigDecimal(y/100);
		BigDecimal dealFaceVale = new BigDecimal("1000000000");
		BigDecimal couponRateBG = new BigDecimal(0.20);
		BigDecimal presentValue = offeredValue.add(offeredValue.multiply(yield).multiply(yearFraction))
				.subtract(dealFaceVale.multiply(couponRateBG).multiply(yearFraction));
		
		BigDecimal one = BigDecimal.ONE;
		
		System.out.println("one: " + one);
		
		return presentValue;
	}

}
