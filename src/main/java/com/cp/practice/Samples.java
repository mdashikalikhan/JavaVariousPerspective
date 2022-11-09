package com.cp.practice;

import java.util.Arrays;

public class Samples {
    int count = 0;
    final int[] arr = new int[5];
    public Samples()
    {
        count++;
        System.out.println(count);
        arr[0]=6;
        arr[1]=6;
        arr[0]=5;
        

        System.out.println(Arrays.toString(arr));

        
        
    }
    public static void main(String[] args) {
        System.out.println((50/25.0)*Integer.parseInt("10") + 50);
        Samples s1 = new Samples();
        Samples s2 = new Samples();
        Samples s3 = new Samples();

        int a = 0;
        a = a++ + ++a;

        System.out.println(a);
        //System.out.println(x);
    }
}

class Base1{
    int x = 0;
    public void m1(){

    }
}

class Child1 extends Base1{
    @Override
    public final void m1() {
        // TODO Auto-generated method stub
        super.m1();
    }
}
