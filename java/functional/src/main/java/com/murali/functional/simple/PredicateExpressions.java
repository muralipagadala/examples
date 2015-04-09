/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.functional.simple;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 *
 * @author MPAGTPNY
 */
public class PredicateExpressions {
    public static void main(String...args){
        final Predicate<Integer> atleast5 = x -> x > 5;
        System.out.println("Atleast 5 :"+atleast5.test(6));
    }
}
