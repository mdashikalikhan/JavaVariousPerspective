package com.interview;

public class Polymorphism {
    public static void main(String[] args) {
        Base1 base1 = new Child1();
        System.out.println(base1.getArea(10, 20));
        System.out.println(base1.getLength(10, 20));
    }
}
