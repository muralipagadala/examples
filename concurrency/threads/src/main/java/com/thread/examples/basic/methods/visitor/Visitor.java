package com.thread.examples.basic.methods.visitor;

import java.util.Random;

public class Visitor extends Thread {

        public int id;
        Random numGen = new Random();
        private Object doneLock;
        public int availableCars;

        public Visitor(int i, int avCars, Object doneLock) {
                this.id = i;
                this.availableCars = avCars;
                this.doneLock = doneLock;

        }

        public void run() {
                int r = numGen.nextInt(1000);
                try {
                        Thread.sleep(r);
                } catch (InterruptedException e1) {
                        e1.printStackTrace();
                }
                testFun();
        }

        public synchronized void testFun() {
                // This guard only loops once for each special event, which may not
                // be the event we're waiting for.
                while (Monitor.availableCars < 4) {
                        try {
                                System.out.println(id + " is about to wait..(cars ="+ availableCars +")");
                                synchronized (doneLock) {
                                        doneLock.wait();
                                }

                        } catch (InterruptedException e) {
                        }
                }
                System.out.println(id + " is no longer waiting!");
        }

}