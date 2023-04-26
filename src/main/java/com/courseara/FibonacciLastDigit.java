package com.courseara;

import java.util.Scanner;

public class FibonacciLastDigit {

    private static int[] arrFib;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int num1 = scn.nextInt();

        scn.close();

        arrFib = new int[num1 + 1];
        arrFib[0] = 0;
        arrFib[1] = 1;
        for(int i=2; i<=num1; i++) {
            arrFib[i] = (arrFib[i-1] + arrFib[i-2])%10;
        }
        System.out.println(arrFib[num1]);
    }

    
}
