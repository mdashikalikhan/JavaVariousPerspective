package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {

	public static void main(String[] args) {
		String S=")(";
		
		Stack<Character> stack = new Stack<>();
		
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		
		
		
		
		for(int i=0; i< S.length(); i++) {
			if(S.charAt(i)=='(' || S.charAt(i)=='[' || S.charAt(i)=='{') {
				stack.push(S.charAt(i));
			} else if(S.charAt(i)==')' || S.charAt(i)=='}' || S.charAt(i)==']') {
				if(stack.size()==0) {
					System.out.println("BREAK");
					break;
				}
				Character c = stack.pop(); 
				if(c !=map.get(S.charAt(i))){
					System.out.println("Wrong: " + c);
				} 
			}
		}
		
		if(stack.size()==0) {
			System.out.println("OK");
		}

	}

}
