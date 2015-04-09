package com.thread.examples.agd.pcj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NaiveStopWatch extends JFrame implements ActionListener {
  private boolean running;
  JButton startStopButton;
  JLabel timeLabel;

  @Override protected void frameInit() {
    super.frameInit();
    getContentPane().setLayout(new FlowLayout());
    startStopButton = new JButton();
    timeLabel = new JLabel();
    startStopButton.setText("Start");
    timeLabel.setText("0");
    getContentPane().add(startStopButton);
    getContentPane().add(timeLabel);

    startStopButton.addActionListener(this);
    }

    //This will not work
    public void actionPerformed(final ActionEvent event) {
      if (running) stopCounting(); else startCounting();
    }

    private void startCounting() {
      startStopButton.setText("Stop");
      running = true;
      for(int count = 0; running; count++) {
        timeLabel.setText(String.format("%d", count));
        try {
          Thread.sleep(1000);
        } catch(InterruptedException ex) {
            throw new RuntimeException(ex);
        }
      }
    }

    private void stopCounting() {
      running = false;
      startStopButton.setText("Start");
    }

  public static void main(final String[] args) {

    NaiveStopWatch stopWatch = new NaiveStopWatch();
    stopWatch.setSize(200, 100);
    stopWatch.setVisible(true);
  }
}