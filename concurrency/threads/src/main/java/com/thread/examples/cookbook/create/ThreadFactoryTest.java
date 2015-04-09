package com.thread.examples.cookbook.create;


public class ThreadFactoryTest {

        public static void main(String...args){

                MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
                Task task = new Task();

                Thread runTask = null;
                System.out.println("Starting a new Thread.. ");
                for(int i = 0 ; i < 10; i++){
                        runTask = factory.newThread(task);
                        runTask.start();
                }

                System.out.printf("Factory stats:\n");
                System.out.printf("%s\n",factory.getStats());
        }
}