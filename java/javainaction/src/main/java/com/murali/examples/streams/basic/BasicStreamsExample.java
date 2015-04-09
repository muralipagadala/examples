package com.murali.examples.streams.basic;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.murali.examples.domain.Dish;

/**
 * Let us say we have DISH TABLE in databse which contains NAME, TYPE ( MEAT, FISH, OTHER), VEGETERIAN ( TRUE|FALSE), CALORIES columns
 * Now we can execute the following Query
 * Select NAME from DISH where CALORIES > 400 ORDER BY CALORIES
 * @author mpagadala
 *
 */

public class BasicStreamsExample {

	public static void main(String...args){
        // Java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        
        Map<Dish.Type, List<Dish>> dishesByType = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(dishesByType);

        System.out.println("Three High Calories Dish name :"+getThreeHighCalorieDishNames(Dish.menu));
    }
	
	
    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() > 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
	

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
    	return dishes.stream()
    			.filter( dish -> dish.getCalories() > 400)
    			.sorted(comparing(Dish::getCalories))
    			.map(Dish::getName)
    			.collect(Collectors.<String>toList());
    }
    /**
     * This is Notes not a documentation
     * 
     * 1. Data source : list of dishes and it provides a sequence of elements to the stream.
     * 2. Apply a series of data processing operations on the stream : filter, map, lit and collect.
     * All these operations except collect returns another Stream so they can be connected to form
     * a pipeline, which can be viewed as a QUERY on the source
     * 3. Finally the collect operations starts processing the pipeline to return a result ( its different bcz it returns something other than a stream, her, a List)
     * No result is produced, an indeed no element from menu is even selected, until collect is invoked.
     * We can think of it as if the method invocations in the chain are queued up until collect is called
     * 
     * filter - Takes a lambda to exclude certain elements from the stream.
     * map - Takes a lambda to TRANSFORM AN ELEMENT INTO ANOTHER ONE or TO EXTRACT INFORMATION.
     * limit - Truncate a stream to contain no more than a given number of elements.
     * collect - Converts a STREAM into ANOTHER FORM
     * 
     * Pure declarative way : 'Find names of three high-calorie dishes'
     * Filtering -> Extracting -> Truncating, they are available through Streams libray. As a result 
     * Streams API has more flexibility to decide how to optimize this pipeline.
     */
    
    /**
     * @param dishes
     * @return
     */
    public static List<String> getThreeHighCalorieDishNames(List<Dish> dishes){
    	return dishes.stream()                  
    			.filter(dish -> dish.getCalories() > 300) 
    			.sorted(comparing(Dish::getName)) 
    			.map(Dish::getName) 
    			.limit(3) 
    			.collect(toList());
    }
}
