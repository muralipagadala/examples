/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author MPAGTPNY
 */
public class PickDifferentNames {

    static final List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String... args) {
        {
            final long countFriendsStartN
                    = friends.stream()
                    .filter(checkIfStartsWith("N")).count();
            final long countFriendsStartB
                    = friends.stream()
                    .filter(checkIfStartsWith("B")).count();

            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }
        
        {
            System.out.println("################ BLock 2 ####################3");
            final Function<String, Predicate<String>> startsWithLetter = 
                    (String letter) -> {
                        Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                        return checkStarts;
                    };
            
            final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
            final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }
        
        {
             System.out.println("################ Lambda 3 ####################3");
            final Function<String, Predicate<String>> startsWithLetter =
                    (String letter) -> (String name) -> name.startsWith(letter);
            
            final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
            final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }
        
        {
             System.out.println("################ Lambda 4 ####################3");
            final Function<String, Predicate<String>> startsWithLetter =
                    letter -> name -> name.startsWith(letter);
             final long countFriendsStartN = friends.stream().filter(startsWithLetter.apply("N")).count();
            final long countFriendsStartB = friends.stream().filter(startsWithLetter.apply("B")).count();

            System.out.println(countFriendsStartN);
            System.out.println(countFriendsStartB);
        }
    }

    public static Predicate<String> checkIfStartsWith(String letter) {
        return name -> name.startsWith(letter);
    }
    
    
}
