package com.thread.examples.basic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import java.text.*;

import static java.lang.System.out;


public class SecondCounterLockup extends JComponent{

        private boolean keepRunning;
        private Font paintFont;
        private String timeMsg;
        private int arcLen;

        public SecondCounterLockup(){
                paintFont = new Font("SansSerif", Font.BOLD, 14);
                timeMsg = "Never Started";
                arcLen = 0;
        }

        public void runClock(){
                out.println("Thread running runClock() is "+Thread.currentThread().getName());
                DecimalFormat fmt = new DecimalFormat("0.000");
                long normalSleepTime = 100;

                int counter = 0;
                keepRunning = true;

                while ( keepRunning ) {
                        try {
                                Thread.sleep(normalSleepTime);
                        }catch ( InterruptedException x ) {
                        }
                        counter++;
                        double counterSecs = counter / 10.0;
                        timeMsg = fmt.format(counterSecs);
                        arcLen = ( ( ( int ) counterSecs ) % 60 ) * 360 / 60;
                        repaint();

                }
                out.println("runClock [exit]");
        }

        public void stopClock(){
                keepRunning = false;
        }

        public void run() {
                runClock();
        }

        public void paint(Graphics g) {
                out.println("Thread that invoked paint() is :" +Thread.currentThread().getName());
                g.setColor(Color.black);
                g.setFont(paintFont);
                g.drawString(timeMsg, 0, 15);
                g.fillOval(0, 20, 100, 100);  // black border
                g.setColor(Color.white);
                g.fillOval(3, 23, 94, 94);  // white for unused portion
                g.setColor(Color.blue);  // blue for used portion
                g.fillArc(2, 22, 96, 96, 90, -arcLen);
        }

}