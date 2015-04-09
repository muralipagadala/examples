package com.generics.examples.bounded2;

import java.util.ArrayList;
import java.util.List;

public class Lists<T extends Number> {

        public static <T> List<T> toList(T...args){
                List<T> list = new ArrayList<T>();
                for(T obj : args){
                        list.add(obj);
                }
                return list;
        }
}