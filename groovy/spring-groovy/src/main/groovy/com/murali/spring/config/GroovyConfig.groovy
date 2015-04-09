package com.murali.spring.config

import com.murali.spring.groovy.aspect.AccountAspect
import com.murali.spring.groovy.dao.AccountDAO
import com.murali.spring.groovy.domain.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Scope

//@Configuration
//@EnableAspectJAutoProxy(proxyTargetClass=true)
class GroovyConfig {

	//@Autowired
	AccountDAO dao
	
	@Bean @Scope("prototype")
	Account prototypeAccount() {
		int newId = dao.createAccount(100.0)
		new Account(id:newId,balance:100.0)
	}
	
	@Bean
	AccountAspect accountAspect() {
		new AccountAspect()
	}
}
