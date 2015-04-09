package com.murali.functional.exercise.ch1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListSelectFiles {

    public static void main(String... args)throws Exception {
        final String[] files
                = new File(".").list(new java.io.FilenameFilter() {
                    public boolean accept(final File dir, final String name) {
                        return name.endsWith(".xml");
                    }
                });
        System.out.println(files.length);
        
        Files.newDirectoryStream(
                Paths.get("."), path -> path.toString().endsWith(".xml"))
                .forEach(System.out::println);
        new File(".").listFiles(File::isHidden);
    }
}
