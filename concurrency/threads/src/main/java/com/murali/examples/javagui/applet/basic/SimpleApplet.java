package com.murali.examples.javagui.applet.basic;

import java.awt.Graphics;

public class SimpleApplet extends BaseApplet{

	private static final long serialVersionUID = -4496835989544398480L;

	public void paint(Graphics g){
		g.drawString("Simple Applet", 20, 20);
	}
	
}
