package com.cp.practice;

import java.math.BigDecimal;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<>();
		set.add(10);
		set.add(2);
		set.add(1);
		set.add(1);
		set.add(4);
		set.add(5);
		System.out.println(set);
		System.out.println(set.first() + "   " + set.last());
		System.out.println(set.lower(1) + "   " + set.ceiling(5));
		set.remove(2);
		System.out.println(set);
		System.out.println(set.contains(-1));
		int i=0;
		for(i=0; i<=100; i++) {
			if(i==5) {
				break;
			}
		}
		System.out.println("i = " + i);
		BigDecimal first = BigDecimal.valueOf(300);
		BigDecimal second = BigDecimal.valueOf(200);
		System.out.println(first.compareTo(second));
	}
}
