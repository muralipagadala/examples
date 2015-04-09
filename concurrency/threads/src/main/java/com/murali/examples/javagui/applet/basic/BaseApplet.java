package com.murali.examples.javagui.applet.basic;

import java.applet.Applet;

public class BaseApplet extends Applet {

	public void init(){
		System.out.println("Applet initialized...");
	}
	
	public void destroy(){
		System.out.println("Applet destroyed...");
	}
	
	public void start(){
		System.out.println("Applet started..");
	}
	
	public void stop(){
		System.out.println("Applet stopped...");
	}
}
