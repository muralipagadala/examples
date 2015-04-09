package com.murali.functional.comparators;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListSubDirectories {
    public static void main(String...args){
        listTheHardWay();
        betteryWay();
    }
    
    private static void betteryWay(){
        List<File> files =
                Stream.of(new File(".").listFiles())
                .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
                .collect(Collectors.toList());
        System.out.println("Count :"+files.size());
    }
    
    private static void listTheHardWay(){
        List<File> files = new ArrayList<File>();
        File[] filesInCurrentDir = new File(".").listFiles();
        for(File file : filesInCurrentDir){
            File[] filesInSubDir = file.listFiles();
            if(filesInSubDir != null){
                files.addAll(Arrays.asList(filesInSubDir));
            }else{
                files.add(file);
            }
        }
        System.out.println("Count: " + files.size());
    }
}
