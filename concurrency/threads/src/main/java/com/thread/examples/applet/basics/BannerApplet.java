package com.thread.examples.applet.basics;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

public class BannerApplet extends Applet implements Runnable {

        private String msg = "A Simple Moving Banner.";
        private boolean stopFlag;
        private int status;
        private Thread t;

        public void init(){
                System.out.println("init [enter] ");
                setBackground(Color.cyan);
                setForeground(Color.red);
                System.out.println("init [exit] ");
        }

        public void start(){
                System.out.println("start [enter] ");
                t = new Thread(this);
                stopFlag = false;
                t.start();
                System.out.println("start [exit] ");
        }

        public void paint(Graphics g){
                System.out.println("paint [enter] ");
                g.drawString(msg, 50, 30);
                showStatus("Murali Pagadala");
                URL url = getCodeBase();
                String message = "Code base :"+url.toString();
                g.drawString(message, 70, 80);

                url = getDocumentBase();
                message = "Document base :"+url.toString();
                g.drawString(message, 90, 120);
                System.out.println("paint [exit] ");

        }

        public void stop(){
                System.out.println("stop [enter] ");
                stopFlag = true;
                t = null;
                System.out.println("stop [exit] ");
        }

        public void destroy(){
                System.out.println("destroy [enter] ");
                System.out.println("destroy [exit] ");
        }

        public void run() {
                char ch;
                try{
                        for(;;){
                                repaint();
                                Thread.sleep(250);
                                ch = msg.charAt(0);
                                msg = msg.substring(1, msg.length());
                                msg += ch;
                        }
                }catch(InterruptedException ie){
                        ie.printStackTrace();
                }
        }

}