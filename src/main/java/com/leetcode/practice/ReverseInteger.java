package com.leetcode.practice;

public class ReverseInteger {
	public static void main(String[] args) {
		int num1 =  -2147483648;
		int x = num1%10;
		System.out.println(x);
		System.out.println(reverse(num1));
		System.out.println(0x7fffffff);
		
		System.out.println(746384741);
	}
	
	public static int reverse(int x) {

		long num = x;
		
		if(x<0) {
			num = -num;
		}
		
		if(num>Integer.MAX_VALUE) {
			return 0;
		}
		
		
		long rev=0;
		while(num!=0) {
			int rem = (int)num%10;
			rev = rev * 10 + rem;
			num = num/10;
		}
		
		if(rev>Integer.MAX_VALUE) {
			return 0;
		}
		return (int)(x<0?-rev:rev);
	}
	
	/**
	 * class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
	 */
}
