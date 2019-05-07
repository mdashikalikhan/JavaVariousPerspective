package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class StringMatching {

	public StringMatching() {
	}

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		if(map.get("abc")==null) {
			map.put("abc", 1);
		}
		else {
			map.put("abc", map.get("abc")+1);
		}
		if(map.get("abc")==null) {
			map.put("abc", 1);
		}
		else {
			map.put("abc", map.get("abc")+1);
		}
		System.out.println(map.get("abc"));
		
	}

}
