package com.thread.examples.lock;

import com.thread.examples.exception.NegativeSemaphoreException;

public class Semaphore {

        private int count;

        public Semaphore(int initCount)throws NegativeSemaphoreException{
                if(initCount<0){
                        throw new NegativeSemaphoreException();
                }
                count = initCount;
        }

        public Semaphore(){
                count = 0;
        }

        public synchronized void down()throws InterruptedException{
                while(count == 0){
                        wait();
                }
                count--;
        }

        public synchronized void up(){
                count++;
                notify();
        }
}