package com.thread.examples.lock;

public class Lock {

        protected boolean locked;

        public Lock(){
                locked = false;
        }

        public synchronized void lock()throws InterruptedException{
                while(locked){
                        wait();
                }
                locked = true;
        }

        public synchronized void unlock(){
                locked = false;
                notify();
        }
}
