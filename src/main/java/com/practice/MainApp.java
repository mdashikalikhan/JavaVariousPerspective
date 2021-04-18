package com.practice;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		List<String> stringList = new ArrayList<>();
		stringList.add("abc");
		stringList.add("def");
		stringList.add("ghi");
		stringList.add("jkl");
		String strArray[] = stringList.toArray(new String[0]);
		System.out.println(strArray[3]);
		
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);
		integerList.add(4);
		integerList.add(5);
		
		Integer[] intArray = integerList.toArray(new Integer[0]);
		System.out.println(intArray[4]);
		
	}
}
