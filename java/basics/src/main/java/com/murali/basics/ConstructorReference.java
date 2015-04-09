/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

/**
 *
 * @author mpagtpny
 */
public class ConstructorReference {
    public static void main(String...args){
        VendorProvider provider = Vendor::new;
        Vendor vendor = provider.getVendor("John", 30);
        System.out.println("->Vendor Name: "+vendor.name);
        System.out.println("->Vendor Age: "+vendor.age);
    }
}

interface VendorProvider{
    Vendor getVendor(String s, Integer i);
}
class Vendor{
    String name;
    Integer age;
    Vendor (String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
