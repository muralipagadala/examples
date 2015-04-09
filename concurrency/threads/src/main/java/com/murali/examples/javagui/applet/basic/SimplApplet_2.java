package com.murali.examples.javagui.applet.basic;

import java.awt.Color;
import java.awt.Graphics;

public class SimplApplet_2 extends BaseApplet{	
	private String msg;

	public void paint(Graphics g){
		g.drawString("Simple Applet", 20, 20);
	}
	
	public void init(){
		super.init();
		setBackground(Color.MAGENTA);
		setForeground(Color.yellow);
	}
	
}
