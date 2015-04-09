package com.thread.examples.cookbook.synchronization;


/**
 * SyncTest_1.java
 *
 * @author Murali Pagadala
 * @version 1.0
 * <BR><BR>
 * <B>Revision History:</B><UL>
 * <LI>Jan 31, 2013(N73550) Baseline.</LI>
 * </UL>
 */

public class SyncTest_1 {

        public static void main(String...args){
                Account account = new Account();
                account.setBalance(1000);

                Company company = new Company(account);
                Bank bank = new Bank(account);

                Thread companyThread = new Thread(company);
                Thread bankThread = new Thread(bank);

                System.out.printf("Account : Initial Balance: %d\n",account.getBalance());

                companyThread.start();
                bankThread.start();

                try{
                        companyThread.join();
                        bankThread.join();
                        System.out.printf("Account : Final Balance: %d\n",account.getBalance());
                }catch(InterruptedException ie){
                        ie.printStackTrace();
                }
        }
}