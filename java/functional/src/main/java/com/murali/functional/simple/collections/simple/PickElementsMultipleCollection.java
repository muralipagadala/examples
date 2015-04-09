package com.murali.functional.simple.collections.simple;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PickElementsMultipleCollection {
    static final List<String> friends
            = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    static final List<String> comrades
            = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
    static final List<String> editors
            = Arrays.asList("Brian", "Jackie", "John", "Mike");
    
    public static void main(String... args) {
        final Predicate<String> startsWithN = name -> name.startsWith("N");
        //final Predicate<String> startwsWithNN = (name -> name.startsWith("N").collect(Collectors.toList()));
        
        List<String> friendsWithN = friends.stream().filter(startsWithN).collect(Collectors.toList());
        List<String> comradesWithN = comrades.stream().filter(startsWithN).collect(Collectors.toList());
        List<String> editorsWithN = editors.stream().filter(startsWithN).collect(Collectors.toList());
        
        System.out.println(friendsWithN);
        System.out.println(comradesWithN);
        System.out.println(editorsWithN);
    }
}
