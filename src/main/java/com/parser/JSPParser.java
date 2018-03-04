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

	private void test1() {
		StringBuffer sb = new StringBuffer("sadasd");
		test2(sb);
		System.out.println(sb);
		
		String str ="sadsafd";
		test3(str);
		System.out.println(str);
	}
	
	private void test2(StringBuffer sb) {
		sb.append("12345");
	}
	
	private void test3(String str) {
		str+="12345";
	}

	public static void main(String args[]) {
		String filePath = "D:\\DEV_BRANCH_K1\\Panaceaweb\\WebRoot\\ACC\\mpgm.jsp";
		File file = new File(filePath);
		JSPRead jspReader = new JSPRead();
		try {
			jspReader.parseJSP(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*String html="<!--<html--><html";
		int index = html.indexOf("-->");
		System.out.println(html.indexOf("-->"));
		html = html.substring(index+3);
		System.out.println(html);
		
		index = html.indexOf("<html");
		System.out.println(index);
		html = html.substring(index+5);
		System.out.println(html);
		index = html.indexOf("<html");
		System.out.println(index);
		html = "<abcd><b>sadfasfef</b>dsfdsafdsfds<!--hdbfhdsdsf--></abcd>dmfjdsaf<!--mfnkjdsnf-->sd";
		StringBuffer text = new StringBuffer(html) ;
		text.replace(text.indexOf("<!--"), text.indexOf("-->")+3, "");
		text.replace(text.indexOf("<!--"), text.indexOf("-->")+3, "");
		
		System.out.println(text);
		
		text = new StringBuffer("ahsdhsad-->ashdbsad%>123214");
		StringTokenizer text_tokens = new StringTokenizer(text.toString(), "-->,%>");
		while(text_tokens.hasMoreTokens()) {
			System.out.println(text_tokens.nextToken());
		}
		System.out.println("Last Index of --> is " + text.lastIndexOf("%>"));
		html = "#<abcd><b>sadfasfef</b>dsfdsafdsfds<!--hdbfhdsdsf--></abcd>dmfjdsaf<!--mfnkjdsnf-->sdlast";
		text = new StringBuffer(html) ;
		text.replace(0, text.lastIndexOf("#")+1, "");
		System.out.println(text);
		text.delete(0, text.length());
		System.out.println(text.toString().equals(""));
		html = "#<abcd><b>sadfasfef</b>dsfdsafdsfds<!--hdbfhdsdsf--></abcd>dmfjdsaf<!--mfnkjdsnf-->sdlast";
		text = new StringBuffer(html) ;
		text.replace(text.indexOf("<!--"), text.length(), "");
		System.out.println(text);
		html = "#<abcd><b>sadfasfef</b>dsfdsafdsfds<!--hdbfhdsdsf--></abcd>dmfjdsaf<!--mfnkjdsnf-->sdlast";
		text = new StringBuffer(html) ;
		text.replace(0, text.indexOf("<b"), "");
		System.out.println(text);
		
		Scanner scanner = new Scanner("<sadns>  \n"
				+ " sjadn smadn smandb");
		System.out.println(scanner.next());
		System.out.println(scanner.next());
		
		html = "dksadm< skdlnkald >sakjd< / sakjdkjsajd >";
		
		StringUtils.substringBetween(html, "<>");
		
		html = "<dsasa shbdaj>";
		System.out.println(html.substring(html.indexOf("<")+1, html.indexOf(">")));
		JSPParser parser1 = new JSPParser();
		parser1.test1();
		
		html="START\ndfbjdsf\n               nsfdb hjbfds jdsfb jdsbfkjds kjdsbds ";
		String splitArray[] = html.split("\\s+");
		for(String txt : splitArray) {
			System.out.println(txt);
		}
		html="";
		splitArray = html.split("\\s+");
		System.out.println(splitArray[0]);
		
		html="sdhad<sadasfd>1sfjdadjf>";
		System.out.println(html.toString().substring(html.indexOf(">")+1));
		System.out.println(!html.toString().contains("|"));
		html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
		System.out.println(html.substring(html.indexOf(">")+1).length());*/
	}
}
