package com.leetcode.practice;

import java.util.Arrays;

public class DivideTwoInteger {
	public static void main(String[] args) {
		System.out.println(divide(-231, 3));
		int a = 27;
		a= a<<1;
		System.out.println(a);
		
		a= a<<1;
		System.out.println(a);
		
		a = 22;
		a = a >> 1;
		
		System.out.println(a);
		
		System.out.println((4<<3));
		
		System.out.println((4 * (2*2*2)));
		
		System.out.println((1<<31)-100);
		
		System.out.println((-3<<2));
		
		a = Math.abs(Integer.MIN_VALUE+1);
		
		System.out.println(a);
		
		System.out.println(1<<1);
		
		String s[] = {"1", "2", "15", "-7", "300"};
		Arrays.sort(s);
		System.out.println(Arrays.toString(s));
		
		a = 40;
		int b = 2;
		int ans = 0;
		for(int i=31; i>=0; i--) {
			if(b<<i <=a) {
				a -= (b<<i);
				ans += 1<<i;
			}
		}
		
		System.out.println(ans);
		
		long x = (long)1<<31;
		
		System.out.println(1<<4);
		
		x = 10;
		long y =3;
		
		
		
	}
	
	public static int divide(int dividend, int divisor) {
        /*int maxNegative = -2147483648;
        int maxPositive = 2147483647;
        
        if(dividend==maxNegative && divisor == -1){
            return maxPositive;
        }
        
        int sign = 1;
        
        if((divisor>0&&dividend<0) || (divisor<0&&dividend>0)) {
        	sign = -1;
        }
        
        if(divisor==1 || divisor==-1){
            return sign==1 ? dividend : -dividend ;
        }
        
        int count = 0;
        
        if(divisor>0) {
        	divisor = -divisor;
        }
        
        if(dividend>0) {
        	dividend = -dividend;
        }
        int t = divisor;
        while(dividend-divisor>=dividend) {
        	//System.out.println(divisor);
        	count++;
        	if(dividend-divisor>t) {
        		break;
        	}
        	divisor = divisor + t;
        }
        
        return sign==-1 ? -count : count;*/
		
		
		int count = 0;
		
		
		
		if(dividend==Integer.MIN_VALUE && divisor==-1) {
			return Integer.MAX_VALUE;
		}
		
		long x = dividend;
		long y = divisor;
		
		
		
		boolean sign = (dividend>0 && divisor>0) || (dividend<0 && divisor<0);
		
		x = Math.abs(x);
		y = Math.abs(y);
		
		if(x==y){
            return sign ? 1 : -1;
        }
        
        if(y==1){
            return sign ? (int)x : (int)-x;
        }
		
		while(x>=y) {
			//int t = 0;
			int i=0;
			while((long)(y<<++i)<=x) {
				//t++;
			}
			count += 1<<(i-1);
			x -= y<<(i-1);
		}
		
		return sign? count : -count;
		
    }
}
