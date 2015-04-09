/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * static final List<String> friends = 
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static void main(String...args){
        
    }
 * @author MPAGTPNY
 */
public class PickElements {
    static final List<String> friends = 
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static void main(String...args){
        final List<String> namesStartsWithN =
                friends.stream()
                    .filter(name -> name.startsWith("N"))
                    .collect(Collectors.toList());
        System.out.println(namesStartsWithN);
    }
}
