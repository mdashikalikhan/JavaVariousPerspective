package com.cp.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
		
		pq.add(new int[] {6,1});
		pq.add(new int[] {7,5});
		pq.add(new int[] {2,1});
		pq.add(new int[] {1,100});
		
		System.out.println(Arrays.toString(pq.poll()));
		System.out.println(Arrays.toString(pq.poll()));
		System.out.println(Arrays.toString(pq.poll()));
		System.out.println(Arrays.toString(pq.poll()));
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(1, 10);
		map.put(1, 10);
		map.put(1, 10);
		map.put(2, 20);
		
		System.out.println(map);
		
		String s = "15YBMATTAX01SOBOHF";
		
		s = s.substring(0,s.length()-6);
		
		System.out.println(s);
				
		int a = 100; 
		int b = 200;
		
		System.out.println(String.valueOf(a) + String.valueOf(b));
	}
}


