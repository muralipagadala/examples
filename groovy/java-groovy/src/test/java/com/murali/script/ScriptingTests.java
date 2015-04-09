package com.murali.script;

import static org.testng.Assert.assertEquals;
import groovy.lang.GroovyShell;
import groovy.util.Eval;

import org.testng.annotations.Test;

public class ScriptingTests {

	@Test
	public void testEvalNoParams(){
		String result = (String)Eval.me("'abc' - 'b'");
		assertEquals(result, "ac");
	}
	
	@Test
	public void testEvalOneParam(){
		String result = (String)Eval.x("a", "'abc' - x");
		assertEquals(result, "bc");
	}
	
	
	@Test
	public void testEvalTwoParam(){
		String result = (String)Eval.xy("a", "b", "'abc' - x - y");
		assertEquals(result, "c");
	}
	
	@Test
	public void testEvalString(){
		GroovyShell shell = new GroovyShell();
		Integer value = (Integer)shell.evaluate("3 + 4");
		assertEquals(value.intValue(), 7);
	}
	
}
