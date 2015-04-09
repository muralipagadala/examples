package com.murali.functional.defaultmethods;

import java.util.Arrays;
import java.util.List;

public class DefaultMethods {
    public static void main(String...args){
        final List<String> languages = Arrays.asList("Java", "Scala", "Groovy");
        languages.forEach(System.out::println);
    }
}
