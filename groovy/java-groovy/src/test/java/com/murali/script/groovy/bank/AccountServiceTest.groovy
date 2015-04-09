package com.murali.script.groovy.bank

import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class AccountServiceTest {

	private AccountService service;
	private Account a1
    private Account a2
	def accounts
	
	@BeforeClass
	public void setUp(){
		service = new AccountService()
		a1 = new Account(1,100)
		a2 = new Account(2,100)
		accounts = [1:a1, 2:a2]
		
		service.dao = { id -> accounts[id] } as AccountDao
	}
	
	@Test
	void testTransferFunds() {
		assertEquals 100, a1.balance, 0.01
		assertEquals 100, a2.balance, 0.01
		service.transferFunds(1, 2, 50)
		assertEquals 50, a1.balance, 0.01
		assertEquals 150, a2.balance, 0.01
	}
	
}
