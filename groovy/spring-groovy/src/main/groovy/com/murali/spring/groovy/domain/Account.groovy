package com.murali.spring.groovy.domain

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

@EqualsAndHashCode(includes=['id'])
@ToString(includeNames=true)
class Account {
	Integer id
	BigDecimal balance
	
	def deposit(amount){
		balance += amount
	}
	
	def withdraw(amount){
		balance -= amount
	}

}
