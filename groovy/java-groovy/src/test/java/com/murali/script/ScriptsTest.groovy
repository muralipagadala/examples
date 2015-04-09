package com.murali.script


import static org.testng.Assert.*;
import groovy.lang.GroovyShell;
import groovy.util.Eval;

import org.testng.annotations.Test;

class ScriptsTest {

	@Test
	public void testHelloWorld(){
		Binding binding = new Binding()
		binding.name = 'Dolly'
		def content = new StringWriter()
		binding.out = new PrintWriter(content)
		GroovyShell shell = new GroovyShell(binding)
		shell.evaluate(new File('src/hello.groovy'))
		assert 'Hello Dolly!' == content.toString().trim()
	}
}
