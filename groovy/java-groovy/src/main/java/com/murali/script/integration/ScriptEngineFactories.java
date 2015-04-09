package com.murali.script.integration;

import java.util.List;
import java.util.logging.Logger;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

public class ScriptEngineFactories {

	 private static Logger log = Logger.getLogger(ScriptEngineFactories.class.getName());
	    
	    public static void main(String[] args) {
	        List<ScriptEngineFactory> factories = new ScriptEngineManager().getEngineFactories();
	        for (ScriptEngineFactory factory : factories) {
	            System.out.println("lang name: " + factory.getLanguageName());
	            System.out.println("lang version: " + factory.getLanguageVersion());
	            System.out.println("engine version: " + factory.getEngineVersion());
	            System.out.println("engine name: " + factory.getEngineName());
	            System.out.println(factory.getNames().toString());
	        }
	    }
}
