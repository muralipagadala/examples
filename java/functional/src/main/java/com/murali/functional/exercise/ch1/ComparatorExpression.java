package com.murali.functional.exercise.ch1;

import java.util.Arrays;


public class ComparatorExpression {
    public static void main(String...args){
         String[] words = {"Talent","Hi", "Hello"};
         System.out.println("Before Sort :"+Arrays.asList(words));
         System.out.println("1. Curren Thread :"+Thread.currentThread().getName());
         Arrays.sort(words, 
            (first, second) -> {
                System.out.println("2.Curren Thread :"+Thread.currentThread().getName());
                return Integer.compare(first.length(), second.length());
            }
         );
         System.out.println("3. Curren Thread :"+Thread.currentThread().getName());
         System.out.println("After Sort :"+Arrays.asList(words));
    }
}
