package com.tutorialspoint;

import java.net.URL;

public class ClassLoaderDemo {
	public static void main(String[] args) throws Exception {
	     
	      Class cls = Class.forName("com.tutorialspoint.ClassLoaderDemo");

	      // returns the ClassLoader object associated with this Class
	      ClassLoader cLoader = cls.getClassLoader();
	    
	      System.out.println(cLoader.getClass());
	      
	      // finds resource with the given name
	      URL url = new URL("file://D:/file.txt");// ClassLoader.getSystemResource("D:/file.txt") /*cLoader.getClass().getResource("D:\\file.txt")*/;
	      System.out.println("Value = " + url);

	      // finds resource with the given name
	      url = cLoader.getResource("newfolder/a.txt");
	      System.out.println("Value = " + url);  
	   }

}
