package com.thread.examples.lock;

public class Barrier {

        protected int count;
        protected int initCount;

        public Barrier(int n)throws Exception{
                if(n <= 0){
                        throw new Exception("Barrier could not be a zero or negative");
                }
                initCount = count = n;
        }

        public void barrier() throws InterruptedException{
                if(--count > 0){
                        wait();
                }
                else{
                        count = initCount;
                        notifyAll();
                }
        }
}