package com.designpattern.abstractfactory;

public class SBL implements Bank{
    
    private final String name;
    
    
    
    public SBL() {
        name = "Sonali Bank Limited";
    }


    @Override
    public String getBankName() {
        // TODO Auto-generated method stub
        return name;
    }
    
}
