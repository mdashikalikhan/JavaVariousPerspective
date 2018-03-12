package com.parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JSPParser {

	private static List<String> jspFiles = new ArrayList<>();

	public static void main(String args[]) {

		/*File file = new File(
				"D:\\DEV_BRANCH_K1\\Panaceaweb\\WebRoot\\GTE\\qbgiss.jsp");

		try {
			JSPRead jspReader = new JSPRead();
			jspReader.parseJSP(file);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		try {
			jspFilePaths(new File("D:/DEV_BRANCH_K1/17.4.0/Panaceaweb/WebRoot"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String filePath : jspFiles) {
			/*System.out.println(filePath);*/
			File file = new File(filePath);

			try {
				JSPRead jspReader = new JSPRead();
				int duplicate = jspReader.parseJSP(file);
				if(duplicate>0){
					System.out.println(file.getName());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 

	}

	private static void jspFilePaths(File dir) throws IOException {
		String str[] = null;

		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				jspFilePaths(file);
			} else if (file.getName().toLowerCase().contains(".jsp")) {
				jspFiles.add(file.getCanonicalPath());
			}
		}

	}

}
