package com.murali.functional.comparators;

import static java.util.Comparator.comparing;
        
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Compare {

    public static void main(String... args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
        
        final List<Person> ascendingAge = 
                people.stream()
                //.sorted((person1, person2) -> person1.ageDifference(person2))
                .sorted(Person::ageDifference)
                .collect(Collectors.toList());
        printPeople("Sorted in ascending order of age: ", ascendingAge);
        
        printPeople("Sorted in descending order of age: ",
                people.stream()
                .sorted((person1, person2) -> person2.ageDifference(person1))
                .collect(Collectors.toList())
        );
        
        Comparator<Person> compareAscending = (person1, person2) -> person1.ageDifference(person2);
        Comparator<Person> compareDescending = compareAscending.reversed();
        
        printPeople("Sorted in ascending order of age: ", 
                people.stream()
                .sorted(compareAscending)
                .collect(Collectors.toList())
        );
       
        
        printPeople("Sorted in descending order of age: ",
                people.stream()
                .sorted(compareDescending)
                .collect(Collectors.toList())
        );
        
        people.stream()
                .min(Person::ageDifference)
                .ifPresent(youngest -> System.out.println("Youngest: " + youngest));
        
        people.stream()
                .max(Person::ageDifference)
                .ifPresent(oldest -> System.out.println("Oldest : "+oldest));
        
        final Function<Person, String> byName = person -> person.getName();
         printPeople("Sorted in descending order of age: ",
                people.stream()
                .sorted(comparing(byName))
                .collect(Collectors.toList())
        );
         
        final Function<Person, Integer> byAge = person -> person.getAge();
        printPeople("Sorted by name and age: ",
                people.stream()
                .sorted(comparing(byName).thenComparing(byAge))
                .collect(Collectors.toList())
        );
        
    }
    

    public static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
