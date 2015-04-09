/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.murali.basics;

import java.util.Arrays;

/**
 *
 * @author mpagtpny
 */
public class MethodReference {
    public static void main(String...args){
        Employee[] employees = {
            new Employee("Nick"), 
            new Employee("Robin"), 
            new Employee("Josh"), 
            new Employee("Andy"), 
            new Employee("Mark")};
        
        System.out.println("Before Sort:");
        dumpEmployee(employees);
        
        Arrays.sort(employees, Employee::myCompare);
        System.out.println("After Sort:");
        dumpEmployee(employees);
    }
    
    public static void dumpEmployee(Employee[] employees){
        for(Employee emp : Arrays.asList(employees)){
            System.out.print(emp.name+", ");
        }
        System.out.println();
    }
}

class Employee {
    String name;
    Employee(String name) {
      this.name = name;
    }
    public static int myCompare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}