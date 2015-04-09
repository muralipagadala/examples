package com.murali.spring.groovy.dao;


import java.math.BigDecimal;
import java.util.List;

import com.murali.spring.groovy.domain.Account;

public interface AccountDAO {
    int createAccount(BigDecimal initialBalance);
    Account findAccountById(int id);
    List<Account> findAllAccounts();
    void updateAccount(Account account);
    void deleteAccount(int id);
}
