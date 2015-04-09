package com.murali.functional.comparators;

import java.io.File;
import java.util.Arrays;

public class ListHiddenFiles {
    public static void main(String...args){
        new File(".").listFiles(File::isHidden);
        File[] files = new File(".").listFiles(File::isHidden);
        System.out.println("Total files :"+files.length);
        Arrays.stream(files).forEach(System.out::println);
    }
}
