/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

public class FirstLambdaExpression {
    private String variable = "Class Level Variable";
    
    public static void main(String...args){
        new FirstLambdaExpression().lambdaExpression();
    }
    
    private void lambdaExpression(){
        String variable = "Method Local Variable";        
        new Thread(() -> {
            System.out.println("->" + variable);
            System.out.println("->" + this.variable);
        }).start();
    }
}
