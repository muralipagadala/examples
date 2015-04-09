/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author MPAGTPNY
 */
public class PrintList {
    static final List<String> friends = 
            Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    public static void main(String...args){
        System.out.println(String.join(", ", friends));
        System.out.println(friends.stream().map(String::toUpperCase).collect(joining(", ")));
    }
}
