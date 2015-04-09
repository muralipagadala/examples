package com.generics.examples.array.covariant;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class ArrayCovariantTest {

        @Test
        public void testArrayCovariant_1(){
        	/**
        	 * When an array is created first time it is tagged with reified type
             * A run time representation of its component type, in this case Integer.
        	 */
            Integer[] intArray = new Integer[]{1,2,3};
            /**
             * Since the Integer[] is considered as subtype of Number[] the following assignment is valid.
             */
            Number[] numArray = intArray;
            /**
             * Every time an array is assigned into an array store exception is raised if the reified type
             * is not compatible with the assigned value. In this case the double cannot be stored into Integer array.
             * numArray[2] = 3.14; // RUNTIME ERROR
             */
            assertEquals(Arrays.toString(intArray), "[1, 2, 3]");
        }
        
        @Test(expectedExceptions=ArrayStoreException.class)
        public void testAssignNotCompatibleTypeToArrayAndThrowRuntimeException_1(){
        	Number[] numbers = new Number[4];
        	numbers[0] = new Integer(10);
        	numbers[1] = new Double(3.14);
        	numbers[2] = new Byte((byte) 0);
        	
        	Integer[] ints = {1, 2, 3, 4, 5};
        	numbers = ints;
        	numbers[4] = 3.14; //attempt of heap pollution !!!NOT A COMPILE TIME ERROR
        }
        
        /**
         * This last line would compile just fine, but if we run this code, we would get an ArrayStoreException 
         * because we’re trying to put a double into an integer array. 
         * The fact that we are accessing the array through a Number reference is irrelevant here, 
         * what matters is that the array is an array of integers.
         */
        @Test(expectedExceptions=ArrayStoreException.class)
        public void testAssignNotCompatibleTypeToArrayAndThrowRuntimeException_2(){        	
        	Integer[] ints = {1, 2, 3, 4, 5};
        	Number[] numbers =  ints;
        	numbers[4] = 3.14; //attempt of heap pollution !!!NOT A COMPILE TIME ERROR
        	
        	/**
        	 * This is like following code
        	 * 		Integer i = 2;
        	 *		Double d = 3.14;
        	 *		i = d; //COMPILE TIME ERROR
        	 *
        	 * In the above scenario we are trying to assign Double to Integer. This means we can fool the 
        	 * compiler but we cannot fool the RUN TIME TYPE SYSTEM.
        	 * 
        	 * This means that at run-time Java knows that this array was actually instantiated as an array 
        	 * of integers which simply happens to be accessed through a reference of type Number[].
        	 */
        }
}
