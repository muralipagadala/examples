package com.murali.spring.groovy.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
class UpdateReporter {

	@Before("execution(void set*(*))")
	void reportOnSet(JoinPoint jp) {
		String method = jp.signature.name
		String base = method - 'set'
		String property = base[0].toLowerCase() + base[1..-1]
		def current = jp.target."$property"
		println "About to change $property from $current to ${jp.args[0]}"
	}
}
