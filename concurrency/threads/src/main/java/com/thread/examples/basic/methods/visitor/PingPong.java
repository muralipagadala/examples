package com.thread.examples.basic.methods.visitor;

public class PingPong {

        // state variable identifying whose turn it is.
        private String whoseTurn = null;

        public synchronized boolean hit(String opponent) {

                String x = Thread.currentThread().getName();
                //System.out.println("Entered by :"+x);


                if (whoseTurn == null) {
                        whoseTurn = x;
                        return true;
                }

                if (opponent.compareTo("DONE") == 0) {
                        whoseTurn = opponent;
                        notifyAll();
                        return false;
                }

                if (x.compareTo(whoseTurn) == 0) {
                        System.out.println("PING! (" + x + ")");
                        whoseTurn = opponent;
                        notifyAll();
                } else {
                        try {
                                long t1 = System.currentTimeMillis();
                                wait(2500);
                                if ((System.currentTimeMillis() - t1) > 2500) {
                                        System.out.println("****** TIMEOUT! " + x + " is waiting for " + whoseTurn + " to play.");
                                }
                        } catch (InterruptedException e) {
                        }
                }
                return true; // keep playing.
        }
}