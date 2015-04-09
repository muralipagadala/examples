package com.thread.examples.interrupt;

public class InterruptReset extends Object {
    public static void main(String[] args) {
        System.out.println("Point X: Thread.interrupted()=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("Point A: isInterrupted()=" + Thread.currentThread().isInterrupted());
        System.out.println("Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println("Point B: isInterrupted()=" + Thread.currentThread().isInterrupted());
        System.out.println("Point Z: Thread.interrupted()=" + Thread.interrupted());
    }
}