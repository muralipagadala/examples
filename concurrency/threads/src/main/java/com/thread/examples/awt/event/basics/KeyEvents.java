package com.thread.examples.awt.event.basics;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents extends Applet implements KeyListener{
        private String msg = "";
        private int x = 10;
        private int y = 20;

        public void init(){
                addKeyListener(this);
        }

        public void keyTyped(KeyEvent ke) {
                msg += ke.getKeyChar();
                repaint();
        }

        public void keyPressed(KeyEvent e) {
                showStatus("Key Up");
        }

        public void keyReleased(KeyEvent ke) {
                showStatus("Key Down");
        }

        public void paint(Graphics g){
                g.drawString(msg, x, y);
        }

}
