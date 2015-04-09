package com.murali.functional.exercise.ch1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
     public static void main(String...args)throws Exception{
        File file = new File("c:/examples/javaexamples/functional");
        //listFiles(file);
        Files.list(Paths.get("."))
                //.filter(Files::isRegularFile)
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }
     
    private static void listFiles(File file){
        if(file.isDirectory()){
            listFiles(file);
        }else{
            System.out.println(file.getName());
        }
    }
}
