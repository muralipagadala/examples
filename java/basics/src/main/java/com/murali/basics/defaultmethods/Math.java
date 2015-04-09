package com.murali.basics.defaultmethods;

public interface Math {
    public int add(int a, int b);
     
    public default int  multiply(int a, int b){
        return a*b;
    }
}
