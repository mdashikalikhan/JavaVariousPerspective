package com.designpattern.abstractfactory;

public abstract class Loan {
    protected double rate;
    abstract void setRate(double rate);
    
    public void calculate(double amount, int years) {
        System.out.println(rate*amount*years);
    }
}
