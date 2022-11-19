package com.cp.practice;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Test implements Serializable {
    int a = 1;
    int b = 2;
 
    Test func(Test obj){
        Test obj3 = new Test();
        obj3 = obj;
        obj3.a = obj.a++ + ++obj.b;
        obj.b = obj.b;
        return obj3;
    }
 
    public static void main(String[] args){
        Test obj1 = new Test();
        Test obj2 = obj1.func(obj1);
 
        System.out.println("obj1.a = " + obj1.a + "  obj1.b = " + obj1.b);
        System.out.println("obj2.a = " + obj2.a + "  obj1.b = " + obj2.b);
        
        String str1 ="abc";
        String str2 ="abc";
        String str3 =new String("abc");
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str2));
        System.out.println(str1==str3);
        System.out.println(str1==str2);
        
        System.gc();
        
        Object result = LocalDate.of(2030, Month.SEPTEMBER, 21)
                .with(TemporalAdjusters.next(DayOfWeek.FRIDAY))
                .plusDays(7)
                .minusWeeks(4).getDayOfWeek();
        System.out.println(result);
    }
}
