package com.practice;

public class EmptyCheck {

	public static void main(String[] args) {
		String s= null;
		if(s!=null && !s.isEmpty()  ) {
			System.out.println("not null");
		} else {
			System.out.println("null");
		}
	}

}
