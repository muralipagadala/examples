package com.murali.functional.java8lambdas.chapter3;

import org.testng.annotations.Test;

import com.murali.functional.java8lambdas.domain.SampleData;


public class IterationTest {
    
    public static void main(String...args){
        lazyPrintOuts();
        internalcountArtistsFromLondon();
    }
    
    @Test
    public static void lazyPrintOuts(){
        Iteration iteration = new Iteration();
        Integer count = iteration.externalCountArtistsFromLondon(SampleData.getThreeArtists());
        System.out.println("Artists from London :"+count);
    }
    
    public static void internalcountArtistsFromLondon(){
        Iteration iteration = new Iteration();
        long count = iteration.internalcountArtistsFromLondon(SampleData.getThreeArtists());
        System.out.println("Artists from London :"+count);
    }
}
