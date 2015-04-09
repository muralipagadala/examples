package com.murali.spring.groovy.aspect


import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

@Aspect
class AccountAspect {
	
	@Pointcut("execution(*Account.deposit(*))")
	void deposits(){}
	
	@Pointcut("execution(*Account.withdraw(*))")
	void withdrawls(){}
	
	@Pointcut("execution(*Account.getBalance(*))")
	void balances(){}
	
	@Before("balances() || deposits() || withdrawls() ")
	void audit(JoinPoint jp){
		String method = jp.signature.name
		println "$method called with ${jp.args} on ${jp.target}"
	}
	
	void auditService(JoinPoint jp){
		
	}
}
