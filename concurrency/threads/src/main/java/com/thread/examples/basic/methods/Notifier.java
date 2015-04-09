package com.thread.examples.basic.methods;

import java.util.Date;

public class Notifier implements Runnable {

        Message message;

        public Notifier(Message message) {
                this.message = message;
        }

        public void run() {
                System.out.println("Notifier is sleeping for 30 seconds at : "+ new Date());
                try {
                        Thread.sleep(3000);
                } catch (InterruptedException e1) {
                        e1.printStackTrace();
                }
                System.out.println("Notifier synchronization before.");
                synchronized (message) {
                        message.setText("Notifier took a nap for 30 seconds");
                        System.out.println("Notifier is notifying waiting thread to wake up at :"+ new Date());
                        message.notify();

                        /**
                         * It should be noted that calling notify() does not actually give up a lock on a resource.
                         * It tells a waiting thread that that thread can wake up. However, the lock is not actually given up until
                         * the notifier's synchronized block has completed. So, if a notifier calls notify() on a
                         * resource but the notifier still needs to perform 10 seconds of actions on the resource
                         * within its synchronized block, the thread that had been waiting will need to wait at
                         * least another additional 10 seconds for the notifier to release the lock on the object,
                         * even though notify() had been called.
                         */
                        /*try {
                                Thread.sleep(10000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }*/

                }
        }
}