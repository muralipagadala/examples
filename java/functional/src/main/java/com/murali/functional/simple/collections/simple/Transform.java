/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple.collections.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MPAGTPNY
 */
public class Transform {
    static final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String...args){
         final List<String> uppercaseNames = new ArrayList<String>();
         friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
         
         System.out.println("################ Demo Starts ##################");
         System.out.println(uppercaseNames);
         
         friends.stream()
                 .map(name -> name.toUpperCase())
                 .forEach(name -> System.out.print(name+ "  "));
         
         friends.stream()
                 .map(name -> name.length())
                 .forEach(count -> System.out.print(count + " "));
         
         friends.stream()
                 .map(String::toUpperCase)
                 .forEach(System.out::println);
         
         friends.stream()
                 .map(String::length)
                 .forEach(System.out::println);
         
         System.out.println("################ Demo Ends ##################");
    }
}
