package com.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EpochTime {

	public static void main(String[] args) throws ParseException {
		long epoch = new SimpleDateFormat("dd/MM/yyyy").parse("02/08/2021").getTime()/1000;
		System.out.println(epoch);
	}

}
