package com.murali.script.groovy.bank

Account a1 = new Account(1, 100)
Account a2 = new Account(2, 100)

def accounts = [1:a1,2:a2]
int nextId = 3

def mock = [
		findAccountById : { id -> accounts[id]},
		findAllAccounts:  { -> accounts.values()},
		createNewAccount: {double bal -> nextId++},
		deleteAccount : {int id -> }
	] as AccountDao

assert mock.findAccountById(1) == a1
mock.findAllAccounts().each{
	assert accounts.containsValue(it)
} 

assert mock.createNewAccount(200) == 3
assert !mock.deleteAccount(3)