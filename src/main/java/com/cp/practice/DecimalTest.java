package com.cp.practice;

import java.math.BigDecimal;

public class DecimalTest {
	public static void main(String[] args) {
		double d = 10.23;
		double trim = Math.round(d);
		System.out.println(trim);
		d = 10.25;
		trim=Math.round(d);
		System.out.println(trim);
		d = 10.55;
		trim=Math.round(d);
		System.out.println(trim);
		d = 10.9;
		trim=Math.round(d);
		System.out.println(trim);
		d = 10.1;
		System.out.println((d%1!=0));
		d = 10;
		System.out.println((d%1));
		
		BigDecimal bg = BigDecimal.valueOf(43434.987);
		System.out.println("bg value = " + bg.negate());
	}
}
