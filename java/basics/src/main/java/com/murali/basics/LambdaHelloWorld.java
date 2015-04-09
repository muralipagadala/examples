/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

public class LambdaHelloWorld {
  interface HelloWorld {
    String hello(String name);
  }
 
  public static void main(String[] args) {        
     HelloWorld helloWorld = (String name) -> { return "Hello " + name; };
     System.out.println(helloWorld.hello("Joe"));
  }
}
