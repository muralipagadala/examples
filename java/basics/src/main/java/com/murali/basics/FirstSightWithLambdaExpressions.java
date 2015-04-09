/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;


public class FirstSightWithLambdaExpressions {
    public static void main(String...arga){
        List list = Arrays.asList(
                (Callable)() -> "Callable 1",
                (Callable) ()-> "Callable 2",
                (Callable) () -> "Callable 3");
        ExecutorService e = Executors.newFixedThreadPool(2);
        List futures = null;
        
        try {
            futures = e.invokeAll(list);
            new FirstSightWithLambdaExpressions().dumpList(futures);
        } catch (InterruptedException  | ExecutionException e1) {
            e1.printStackTrace();
        }
        e.shutdown();
    }
    
    public void dumpList(List<Future> list) throws InterruptedException,
              ExecutionException {
        for (Future future : list) {
            System.out.println(future.get());
        }
    }
}
