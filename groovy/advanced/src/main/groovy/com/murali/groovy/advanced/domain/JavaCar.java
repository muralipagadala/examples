package com.murali.groovy.advanced.domain;

public class JavaCar {

    private int miles;
    private final int year;
    
    public JavaCar(int year){
        this.year = year;
    }
    
    public static void main(String[] args) {
        JavaCar car = new JavaCar(2008);
        System.out.println("Year: " + car.getYear());
        System.out.println("Miles: " + car.getMiles());
        System.out.println("Setting miles");
        car.setMiles(25);
        System.out.println("Miles: " + car.getMiles());
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public int getYear() {
        return year;
    }
}