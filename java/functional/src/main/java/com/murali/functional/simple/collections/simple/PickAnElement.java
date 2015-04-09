/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author MPAGTPNY
 */
public class PickAnElement {
    static final List<String> friends = 
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static void main(String...args){
        pickName(friends, "N");
        pickName(friends, "Z");
    }
    
    public static void pickName(final List<String> names, final String startingLetter) {
        final Optional<String> foundName = names.stream()
                .filter(name -> name.startsWith(startingLetter)).findFirst();
        System.out.println(String.format("A name starting with %s: %s",
                startingLetter, foundName.orElse("No name found")));
        
        foundName.ifPresent(System.out::println);
    }
}
