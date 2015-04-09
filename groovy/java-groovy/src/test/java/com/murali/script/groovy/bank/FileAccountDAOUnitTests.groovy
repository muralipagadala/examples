package com.murali.script.groovy.bank

import static org.testng.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test

class FileAccountDAOUnitTests {

	FileAccountDao dao

	@BeforeMethod
	public void setUp(){
		Expando ex = new Expando()
		ex.data = ''
		ex.splitEachLine = { pattern, clos -> data.splitEachLine(pattern, clos)}
		ex.withWriter = { new StringWriter()}
		ex.println = {data.append(it)}
		dao = new FileAccountDao(accountsFile:ex)
	}
	
	@Test
	void testCreateAndFindNewAccount() {
		int id = dao.createNewAccount(100.0)
		println dao.accountsFile
		
		Account local = new Account(id:id,balance:100.0)
		Account fromDao = dao.findAccountById(id)
		assert local.id == fromDao.id
		assertEquals local.balance, fromDao.balance, 0.01
	}
	
	@Test
	void testFindAllAccounts() {
		(1..10).each { 
			num -> 
			dao.createNewAccount(num*100) 
		}
		println dao.accountsFile
		def accounts = dao.findAllAccounts()
		assert 10 == accounts.size()
		accounts*.balance.each { it in (100..1000) }
	}
	
	@Test
	void testDeleteAccount() {
		(1..10).each { num -> dao.createNewAccount(num*100) }
		def accounts = dao.findAllAccounts()
		assert 10 == accounts.size()
		accounts.each { account -> dao.deleteAccount(account.id) }
		assert 0 == dao.findAllAccounts().size()
	}
}
