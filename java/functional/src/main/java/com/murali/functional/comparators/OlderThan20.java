package com.murali.functional.comparators;

import static java.lang.System.out;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class OlderThan20 {

    public static void main(String... args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));
        
        {
            final List<Person> olderThan20 = new ArrayList<Person>();
            people.stream()
                    .filter(person -> person.getAge() > 20)
                    .forEach(person -> olderThan20.add(person));
            System.out.println("People older than 20: " + olderThan20);
        }
        {
            final List<Person> olderThan20 =
                    people.stream()
                        .filter(person -> person.getAge() > 20)
                        .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
            System.out.println("People older than 20: " + olderThan20);
        }
        
        {
            final Map<Integer, List<Person>> peopleByAge =
                    people.stream().collect(Collectors.groupingBy(Person::getAge));
            System.out.println("People grouped by age: " + peopleByAge);
        }
        {
            Map<Integer, List<String>> nameOfPeopleByAge =
                    people.stream().collect(
                            Collectors.groupingBy(Person::getAge, mapping(Person::getName, toList())));
            System.out.println("People grouped by age: " + nameOfPeopleByAge);
        }
        {
            final Comparator<Person> byAge = Comparator.comparing(Person::getAge);
            final Map<Character, Optional<Person>> oldestPersonInEachAlphabet =
                    people.stream()
                        .collect(groupingBy(person -> person.getName().charAt(0),
                                reducing(BinaryOperator.maxBy(byAge)))
                                
                        );
                        
            System.out.println("Oldest person in each alphabet:");
            System.out.println(oldestPersonInEachAlphabet);
        }
    }
}
