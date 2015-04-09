/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

import java.util.List;
import java.util.Arrays;

/**
 *
 * @author MPAGTPNY
 */
public class WhatIsLambda {
    public static void main(String...args){
        Runnable r = () -> System.out.println("Lambda Expression");
        r.run();
        
        Runnable reg = new Runnable(){
            public void run(){
                System.out.println("Regular Expression");
            }
        };
        reg.run();
        
        new Thread(
            ()->System.out.println("1. Lambda Expression.")
        ).start();
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(i -> System.out.print(i));
        System.out.println();
        list.forEach(System.out::print);
        System.out.println();        
    }
}
