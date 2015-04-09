package com.murali.spring.groovy.dao

import spock.lang.Specification

import com.murali.spring.groovy.domain.Account
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class JdbcAccountDAOSpec extends Specification{

	@Autowired
	AccountDAO accountDAO
	
	def "dao is injected properly"(){
		expect:accountDAO
	}
	
	def "find 3 accounts in sample db"(){
		expect : accountDAO.findAllAccounts().size() == 3
	}
	
	def "find account 0 by id"(){
		when : Account account = accountDAO.findAccountById(0);
		then :
			account.id == 0
			account.balance == 100.0
	}
	
	def "create account and find it"(){
		when :
			int id = accountDAO.createAccount(500.0)
			Account account = accountDAO.findAccountById(id)
		then :
			account.id == id
			account.balance == 500.0
	}
}
