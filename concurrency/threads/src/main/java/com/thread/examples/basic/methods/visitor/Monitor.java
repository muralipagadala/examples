package com.thread.examples.basic.methods.visitor;

public class Monitor {

        public static Object doneLock;
        public static int availableCars;

        public static void main(String[] args) {

                availableCars = 3;
                System.out.println("This is a monitor test:");

                doneLock = new Object();
                int numVisitors = 5;

                for (int i = 0; i < numVisitors; i++) {

                        Visitor newVisitor = new Visitor(i, availableCars, doneLock);
                        newVisitor.start();
                }

                try {
                        Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }

                availableCars = 5;
                synchronized (doneLock) {
                        doneLock.notifyAll();
                }

        }

}