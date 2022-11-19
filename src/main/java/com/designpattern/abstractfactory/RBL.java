package com.designpattern.abstractfactory;

public class RBL implements Bank{
    private final String name;
    
    public RBL() {
        name = "Rupali Bank Limited";
    }


    @Override
    public String getBankName() {
        // TODO Auto-generated method stub
        return name;
    }
}
