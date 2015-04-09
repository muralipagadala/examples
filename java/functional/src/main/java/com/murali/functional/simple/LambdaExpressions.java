/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 *
 * @author MPAGTPNY
 */
public class LambdaExpressions {
    public static void main(String...args){
        {
            Runnable noArguments = () -> System.out.println("No arguments Lambda");
            noArguments.run();

            Thread run = new Thread("Hello"){
                public void run(){
                    System.out.println("Old Runnable Version 1");
                }
            };
            run.start();

            Runnable run2 = new Runnable(){
                public void run(){
                    System.out.println("Old Runnable Version 2");
                }
            };
            run2.run();
        }
        
        {
            ActionListener listener = event -> System.out.println("Button Clicked");
        }
        
        {
           BinaryOperator<Integer> add = (x, y) -> x+y;
            System.out.println("Addition :"+add.apply(4, 5));
       
            Comparator<String> comparator = 
                    (name1, name2) -> Integer.compare(name1.length(), name2.length());
            System.out.println("Comparator Result :"+comparator.compare("Murali", "Pagadala")); 
        }
        
        
        {
            String[] words = {"Talent","Hi", "Hello"};
            System.out.println("Before Sort :"+Arrays.asList(words));
            Arrays.sort(words, 
                (first, second) -> Integer.compare(first.length(), second.length())
            );
            System.out.println("After Sort :"+Arrays.asList(words));
        }
        
        {
            BiFunction<String, String, Integer> comparator =
                    (first,second)->Integer.compare(first.length(), second.length());
            System.out.println("After Sort :"+comparator.apply("Murali", "Pagadala"));
        }
        
        {
            /**
             * Compile error :
             *      checked exceptions matter when a lambda is converted to an 
             *      instance of functional interface. If the body of lambda expression
             *      throws checked exception, that exception need to be declared in
             *      body of the abstract method of target interface.
             * 
             * Solution : catch the exception in lambda expression 
             *            or assign it to a Functional interface which handles the checked exception
             * Runnable sleeper = () -> { System.out.println("Hello!"); Thread.sleep(1000));
             */
            
        }
    }
}
