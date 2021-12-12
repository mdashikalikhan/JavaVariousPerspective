package com.practice;

import java.math.BigDecimal;

import javax.crypto.MacSpi;

public class NullCheck {

	MacSpi spi;
	BigDecimal bgd;
	public NullCheck() {
		super();
		if(spi==null) {
			System.out.println("spi is null");
		}
		if(bgd==null) {
			System.out.println("bgd is null");
		}
	}
	
	public static void main(String[] args) {
		NullCheck check = new NullCheck();
	}
}
