package com.cp.practice;

import java.util.Arrays;

/**
 * xor logic
 * IF A ^ B = C THEN
 *  A = B ^ C OR B = A ^ C
 * [5,2,0,3,1]
 * 2 = 5 ^ X => X = 2 ^ 5
 * 0 = 5 ^ 2 ^ x => x = 0 ^ 5 ^ 2
 * 3 = 5 
 */
public class XorPrefix {
    public static void main(String[] args) {
        // System.out.println(5^2);
        // System.out.println(5^2);
        // System.out.println(5^7);

        int pref[] ={5,2,0,3,1};

        int x = pref[0];
        for(int i=1; i<pref.length; i++){
            
            pref[i] ^=  x;
            x ^= pref[i];
        }
    

        System.out.println(Arrays.toString(pref));

        System.out.println(5^2);

        System.out.println(0^2);
    }
}
