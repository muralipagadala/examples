package com.thread.examples.awt.event.basics;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener {

        String msg = "";
        private int mouseX = 0;
        private int mouseY = 0;

        public void init(){
                addMouseListener(this);
                addMouseMotionListener(this);
        }

        public void paint(Graphics g){
                g.drawString(msg, mouseX, mouseY);
        }

        public void mouseDragged(MouseEvent e) {
                // save coordinates
                mouseX = e.getX();
                mouseY = e.getY();
                msg = "*";
                showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
                repaint();
        }

        public void mouseMoved(MouseEvent e) {
                // show status
                showStatus("Moving mouse at " + e.getX() + ", " + e.getY());
        }

        public void mouseClicked(MouseEvent e) {
                // save coordinates
                mouseX = 0;
                mouseY = 10;
                msg = "Mouse clicked.";
                repaint();
        }

        public void mousePressed(MouseEvent e) {
                // save coordinates
                mouseX = e.getX();
                mouseY = e.getY();
                msg = "Down";
                repaint();
        }

        public void mouseReleased(MouseEvent e) {
                // save coordinates
                mouseX = e.getX();
                mouseY = e.getY();
                msg = "Up";
                repaint();
        }

        public void mouseEntered(MouseEvent e) {
                // save coordinates
                mouseX = 0;
                mouseY = 10;
                msg = "Mouse entered.";
                repaint();
        }

        public void mouseExited(MouseEvent e) {
                // save coordinates
                mouseX = 0;
                mouseY = 10;
                msg = "Mouse exited.";
                repaint();
        }

}