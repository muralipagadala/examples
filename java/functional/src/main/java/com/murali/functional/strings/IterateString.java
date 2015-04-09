package com.murali.functional.strings;

public class IterateString {
    public static void main(String...args){
        String name = "G00gle";
        //name.chars().forEach(System.out::println);
        name.chars().forEach(IterateString::printChar);
        
        name.chars()
                .mapToObj(ch -> Character.valueOf((char)ch))
                .forEach(System.out::println);
        
        name.chars()
                .filter(ch -> Character.isDigit(ch))
                .forEach(System.out::println);
        
        name.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
    }
    
    private static void printChar(int aChar){
        System.out.println((char)aChar);
    }
}
