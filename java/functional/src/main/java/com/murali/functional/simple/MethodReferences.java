package com.murali.functional.simple;

import java.util.Arrays;

public class MethodReferences {
    public static void main(String...args){
        String[] words = {"World","Talent", "Apple"};
        System.out.println("Before Sort :"+Arrays.asList(words));
        Arrays.sort(words, String::compareToIgnoreCase);
        System.out.println("After Sort :"+Arrays.asList(words));
    }
}
