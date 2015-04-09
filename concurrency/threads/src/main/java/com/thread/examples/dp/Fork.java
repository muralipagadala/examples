package com.thread.examples.dp;

import com.thread.examples.lock.Lock;

public class Fork {
        public char id;
        private Lock lock = new Lock();

        public void pickup()throws InterruptedException{
                lock.lock();
        }

        public void putdown()throws InterruptedException{
                lock.unlock();
        }

        public Fork(int i){
                Integer val = new Integer(i);
                id = val.toString().charAt(0);
        }

}
