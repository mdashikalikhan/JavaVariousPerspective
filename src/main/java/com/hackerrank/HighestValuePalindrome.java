package com.hackerrank;

public class HighestValuePalindrome {

	public static void main(String[] args) {
		String s ="632239";
		
		int k = 4;
		
		
		StringBuilder sb = new StringBuilder(s);
		
		
		int positionMismatched = 0;
		
		for(int i =0, j =sb.length()-1; i<j; i++, j--) {
			if(sb.charAt(i)!=sb.charAt(j)) {
				positionMismatched++;
			}
		}
		
		System.out.println("positionMismatched: " + positionMismatched);
		
		if(positionMismatched>k) {
			System.out.println(-1);
			return;
		}
		
		for(int i =0, j =sb.length()-1; i<j; i++, j--) {
			
			if(sb.charAt(i)==sb.charAt(j) && sb.charAt(i) !='9' && k-2 >=positionMismatched) {
				sb.setCharAt(i, '9');
				sb.setCharAt(j, '9');
				k-=2;
			}
			else if(sb.charAt(i)!=sb.charAt(j) && k>0) {
				int val1 = sb.charAt(i);
				int val2 = sb.charAt(j);
				char max = val1>val2 ? sb.charAt(i) : sb.charAt(j);
				if(max != '9' && k-2 >=positionMismatched-1) {
					sb.setCharAt(i, '9');
					sb.setCharAt(j, '9');
					k-=2;
				} else {
					sb.setCharAt(i, max);
					sb.setCharAt(j, max);
					k--;
				}
				
				positionMismatched--;
				
			}
			
		}
		
		if(sb.length()%2==1 && k>0 && sb.charAt(sb.length()/2)!='9') {
			sb.setCharAt(sb.length()/2, '9');
			k--;
		}
			
		
		System.out.println(sb);
		
		System.out.println("k = " + k);
		
	}

}
