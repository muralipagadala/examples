package com.thread.examples.cookbook.synchronization;


/**
 * Company.java
 *
 * @author Murali Pagadala
 * @version 1.0
 * <BR><BR>
 * <B>Revision History:</B><UL>
 * <LI>Jan 31, 2013(N73550) Baseline.</LI>
 * </UL>
 */

public class Company implements Runnable{

        private Account account;

        public Company(Account account){
                this.account = account;
        }

        public void run(){
                for(int i = 0; i < 100; i++){
                        account.deposit(1000);
                }
        }
}