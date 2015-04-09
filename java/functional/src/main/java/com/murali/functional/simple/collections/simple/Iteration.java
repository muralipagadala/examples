package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {
    static final List<String> friends = 
    		Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    
    public static void main(String...args){
        friends.forEach(new Consumer<String>(){
            public void accept(final String name){
                System.out.println(name);
            }
        });
        friends.forEach((final String name) -> System.out.println(name));
        friends.forEach((name) -> System.out.println(name));
        friends.forEach(name -> System.out.print(name));
        friends.forEach(System.out::println);
    }
}
