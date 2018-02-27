package com.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("JAVA 8 Practice");
		Properties prop = System.getProperties(); 
		PrintWriter print = new PrintWriter(System.out);
		prop.list(print);
		
		print.flush();
		
	}
}
