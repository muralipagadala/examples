package com.thread.examples.cookbook.synchronization;

public class Account {

        private long balance;

        public synchronized void deposit(long amount){
                long temp = balance;
                try{
                        Thread.sleep(10);
                }catch(InterruptedException ie){
                        ie.printStackTrace();
                }
                temp += amount;
                balance = temp;
        }

        public synchronized void withdraw(long amount){
                long temp = amount;
                try{
                        Thread.sleep(10);
                }catch(InterruptedException ie){
                        ie.printStackTrace();
                }
                temp -= amount;
                balance = temp;
        }

        public long getBalance() {
                return balance;
        }

        public void setBalance(long balance) {
                this.balance = balance;
        }


}