package com.thread.examples.cookbook.synchronization;


/**
 * Bank.java
 *
 * @author Murali Pagadala
 * @version 1.0
 * <BR><BR>
 * <B>Revision History:</B><UL>
 * <LI>Jan 31, 2013(N73550) Baseline.</LI>
 * </UL>
 */

public class Bank implements Runnable{

        private Account account;

        public Bank(Account account){
                this.account = account;
        }

        public void run(){
                for(int i = 0; i < 100; i++){
                        account.withdraw(1000);
                }
        }

}