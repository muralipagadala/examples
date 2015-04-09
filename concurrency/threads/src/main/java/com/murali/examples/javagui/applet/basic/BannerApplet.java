package com.murali.examples.javagui.applet.basic;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BannerApplet extends Applet implements Runnable{
	private String msg = "Moving banner";
	Thread t = null;
	private volatile  boolean stopFlag = false;
	
	public void start(){
		t = new Thread(this);
		stopFlag = false;
		t.start();
	}

	public void run() {
		for(;;){
			try{
				repaint();
				Thread.sleep(200);
				if(stopFlag){
					break;
				}
			}catch(InterruptedException ie){}
		}
	}
	
	public void stop(){
		stopFlag = true;
		t = null;
	}
	
	public void init(){
		System.out.println("Init thread :"+Thread.currentThread().getName());
		setBackground(Color.cyan);
		setForeground(Color.red);
	}
	
	public void paint(Graphics g) {
		char ch;
		ch = msg.charAt(0);
		msg = msg.substring(1, msg.length());
		msg += ch;
		g.drawString(msg, 50, 30);
		showStatus("Thread : "+Thread.currentThread().getName());
	}

}
