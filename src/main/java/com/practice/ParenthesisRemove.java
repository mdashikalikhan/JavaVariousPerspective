package com.practice;

public class ParenthesisRemove {

	public static void main(String[] args) {
		String s = "(a(b(c)d)";
		
		StringBuilder sb = new StringBuilder();
		
		int opens = 0;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==')' && opens==0) {
				continue;
			}
			if(s.charAt(i)==')') {	
				opens--;
			} else if(s.charAt(i)=='(') {
				opens++;
			}
			sb.append(s.charAt(i));
		}
		
		System.out.println(opens);
		
		while(opens>0) {
			sb.deleteCharAt(sb.lastIndexOf("("));
			opens--;
		}
		
		System.out.println(sb);
	}

}
