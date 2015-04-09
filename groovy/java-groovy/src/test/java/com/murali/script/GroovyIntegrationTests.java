package com.murali.script;

import static org.testng.Assert.assertEquals;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.codehaus.groovy.control.CompilationFailedException;
import org.testng.annotations.Test;

import com.murali.script.groovy.geo.Geocoder;
import com.murali.script.groovy.geo.Location;

public class GroovyIntegrationTests {

	@Test
	public void testLatitudeLongitudeJSR223() throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("groovy");
		engine.put("street", "Blackheath Avenue");
	    engine.put("city","Greenwich");
	    engine.put("state", "UK");
	    engine.eval(new FileReader("src/geocode.groovy"));
    
	    assertEquals(engine.get("lat"), 3);
	    assertEquals(engine.get("lng"), 4);
	}
	
	@Test
	public void testLatLng() {
		Binding binding = new Binding();
		binding.setVariable("street", "Blackheath Avenue");
		binding.setVariable("city", "Greenwich");
		binding.setVariable("state", "UK");
		GroovyShell shell = new GroovyShell(binding);
		try {
			shell.evaluate(new File("src/geocode.groovy"));
			assertEquals(binding.getVariable("lat"), 3);
			assertEquals(binding.getVariable("lng"), 4);
		} catch (CompilationFailedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGeocoder(){
		Location loc = new Location();
		loc.setStreet("1600 Pennsylvania Avenue");
		loc.setCity("Washington");
		loc.setState("DC");
		
		Geocoder geo = new Geocoder();
		geo.fillInLatLong(loc);
		
		assertEquals(3.0, loc.getLatitude());
		assertEquals(4.0,loc.getLongitude());
	}
}
