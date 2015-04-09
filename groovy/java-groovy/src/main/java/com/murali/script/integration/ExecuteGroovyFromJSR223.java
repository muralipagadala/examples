package com.murali.script.integration;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExecuteGroovyFromJSR223 {

	public static void main(String[] args) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
		try {
			engine.eval("println 'Hello, Groovy!'");
			engine.eval(new FileReader("src/hello.groovy"));
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
