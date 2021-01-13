package com.practice;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

public class VillageTravel {

	public static void main(String[] args) {
		int[] T = {2,0,2,2,1,0};
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
		
		for(int i=0; i<T.length; i++) {
			Set<Integer> temp = new HashSet<>();
			int smallVal = Math.min(i,  T[i]);
			int largeVal = Math.max(i, T[i]);
			temp = adjacentMap.get(smallVal);
			
			if(temp==null && smallVal!=largeVal) {
				temp = new HashSet<>();
				temp.add(largeVal);
				adjacentMap.put(smallVal, temp);
			} else if(temp!=null && smallVal!=largeVal) {
				temp.add(largeVal);
				adjacentMap.put(smallVal, temp);
			}
		}
		System.out.println(adjacentMap);
	}

}
