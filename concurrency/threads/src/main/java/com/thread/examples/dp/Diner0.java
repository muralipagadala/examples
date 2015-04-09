package com.thread.examples.dp;


public class Diner0 extends Thread{

        public char state = 't';
        public Fork L,R;

        public Diner0(Fork L, Fork R){
                super();
                this.L = L;
                this.R = R;
        }

        protected void think()throws InterruptedException{
                sleep((long)(Math.random()*7.0));
        }

        protected void eat()throws InterruptedException{
                sleep((long)(Math.random()*7.0));
        }

        public void run(){
                try{
                        for(int i = 0; i < 1000; i++){
                                state = 't';
                                think();
                                state=L.id;
                                sleep(1);
                                L.pickup();
                                state=R.id;
                                sleep(1);
                                R.pickup();
                                state='e';
                                eat();
                                L.putdown();
                                R.putdown();
                        }
                        state = 'd';
                }
                catch(InterruptedException e){
                        System.out.println("InterruptedException:"+e);
                }
        }
}