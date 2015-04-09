package com.murali.script.groovy.bank

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap

class FileAccountDao implements AccountDao{
	def accountsFile
	Map<Integer,Account> accounts = [:] as ConcurrentHashMap<Integer, Account>
	private static int nextId
	boolean dirty
	
	private void readAccountsFromFile() {
		accountsFile.splitEachLine(','){
			line ->
			int id = line[0].toInteger()
			double balance = line[1].toDouble()
			accounts[id] = new Account(id:id,balance:balance)
		}
		nextId = accounts?.keySet().max()?:0
		nextId++
		
		dirty = false
		println accounts
	}
	
	private void writeAccountsToFile() {
		accountsFile.withWriter{
			w ->
			accounts.each{
				id, account ->
				w.println("$id, $account.balance")
			}
		}
		dirty = true
	}

	@Override
	public Account findAccountById(int id) {
		if (dirty) readAccountsFromFile()
		return accounts[id]
	}

	@Override
	public Collection<Account> findAllAccounts() {
		if (dirty) readAccountsFromFile()
		return accounts.values()
	}

	@Override
	public int createNewAccount(double balance) {
		int newId = nextId++
		accounts[newId] = new Account(id:newId,balance:balance)
		writeAccountsToFile()
		return newId;
		return 0;
	}

	@Override
	public void deleteAccount(int id) {
		accounts.remove(id)
		writeAccountsToFile()
	}

}
