package com.hackerrank;

public class AppendAndDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(appendAndDelete("aaaaaaaaaa", "aaaaa", 7));
	}

	static String appendAndDelete(String s, String t, int k) {
		int commonLength = 0;
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) == t.charAt(i)) {
				commonLength++;
			} else {
				break;
			}
		}int a = 10;
		double b = Math.sqrt(a+0.0);
		int totalUnmatchCharacter = s.length() + t.length() - 2 * commonLength;
		System.out.println("commonLength: " + commonLength);
		System.out.println("totalUnmatchCharacter: " + totalUnmatchCharacter);
		System.out.println("k: " + k);
		System.out.println("Length S: " + s.length());
		System.out.println("Length T: " + t.length());
		if (totalUnmatchCharacter == k) {
			return "Yes";
		} else if (totalUnmatchCharacter == 0
				&& (s.length() + t.length() + 1) == k) {
			return "Yes";
		} else if (totalUnmatchCharacter < k
				&& (k - totalUnmatchCharacter) % 2 == 0) {
			return "Yes";
		} else if (totalUnmatchCharacter < k && commonLength == 0
				&& (k - (s.length() + 1 + t.length())) % 2 == 0) {
			return "Yes";
		} else if (s.length()+1+t.length()==k) {
			return "Yes";
		} else {
			return "No";
		}

	}

}
