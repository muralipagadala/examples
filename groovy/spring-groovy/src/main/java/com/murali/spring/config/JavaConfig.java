package com.murali.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.murali.spring.groovy.dao.AccountDAO;
import com.murali.spring.groovy.service.AccountProcessor;


@Configuration
public class JavaConfig {

	@Autowired
	private AccountDAO accountDAO;
	
	@Bean
	public AccountProcessor accountProcessor(){
		AccountProcessor ap = new AccountProcessor();
		ap.setAccounts(accountDAO.findAllAccounts());
		return ap;
	}
}
