package com.thread.examples.deprecated;

public class ThreadExample {

        private Thread internalThread;

        public ThreadExample(){

                Runnable r = new Runnable(){
                        public void run(){
                                for(int i = 0; i < 10; i++){
                                        System.out.println(Thread.currentThread().getName() +" : "+i);
                                }
                        }
                };

                internalThread = new Thread(r);
                internalThread.start();
        }


        public static void main(String...args){
                ThreadExample xample = new ThreadExample();
        }

}