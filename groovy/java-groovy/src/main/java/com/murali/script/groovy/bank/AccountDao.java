package com.murali.script.groovy.bank;

import java.util.Collection;

public interface AccountDao {
    Account findAccountById(int id);
    Collection<Account> findAllAccounts();
    int createNewAccount(double balance);
    void deleteAccount(int id);
}
