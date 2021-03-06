/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics.fi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author MPAGTPNY
 */
public class PredicateTest {
    public static void main(String...args){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        
        System.out.println("Print all numbers:");
        evaluate(list, (n) -> true);
        
        System.out.println("Print no numbers:");
        evaluate(list, (n)->false);
 
        System.out.println("Print even numbers:");
        evaluate(list, (n)-> n%2 == 0 );
 
        System.out.println("Print odd numbers:");
        evaluate(list, (n)-> n%2 == 1 );
 
        System.out.println("Print numbers greater than 5:");
        evaluate(list, (n)-> n > 5 );
    }
    
    private static void evaluate(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n : list){
            if(predicate.test(n)){
                System.out.println(n + " ");
            }
        }
    }
}
