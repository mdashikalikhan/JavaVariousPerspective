package com.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.UUID;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("JAVA 8 Practice");
		Properties prop = System.getProperties(); 
		PrintWriter print = new PrintWriter(System.out);
		prop.list(print);
		
		print.flush();
		
		String str = "sadsadsad";
		System.out.println(str.substring(0, 2));
		System.out.println(str.substring(2));
		
		String random = UUID.randomUUID().toString().toUpperCase();
		System.out.println(random.substring(random.length()-12));
		
	}
}
