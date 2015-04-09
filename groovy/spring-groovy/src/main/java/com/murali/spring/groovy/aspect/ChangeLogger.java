package com.murali.spring.groovy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ChangeLogger {
	@Before("execution(void set*(*))")
	public void trackChange(JoinPoint jp){
		String method = jp.getSignature().getName();
		Object newValue = jp.getArgs()[0];
		System.out.println(method + " about to change to " + newValue + " on " + jp.getTarget());
	}
}
