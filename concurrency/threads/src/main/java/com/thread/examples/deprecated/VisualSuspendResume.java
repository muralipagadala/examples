package com.thread.examples.deprecated;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class VisualSuspendResume extends JPanel implements Runnable {

	private static final String[] symbolList = { "|", "/", "-", "\\", "|", "/","-", "\\" };

	private Thread runThread;
	private JTextField symbolTF;

	public VisualSuspendResume() {
		symbolTF = new JTextField();
		symbolTF.setEditable(false);
		symbolTF.setFont(new Font("Monospaced", Font.BOLD, 26));
		symbolTF.setHorizontalAlignment(JTextField.CENTER);

		final JButton suspendB = new JButton("Suspend");
		final JButton resumeB = new JButton("Resume");

		suspendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Suspending now..");
				suspendNow();
			}
		});

		resumeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Resuming now..");
				resumeNow();
			}
		});

		JPanel innerStackP = new JPanel();
		innerStackP.setLayout(new GridLayout(0, 1, 3, 3));
		innerStackP.add(symbolTF);
		innerStackP.add(suspendB);
		innerStackP.add(resumeB);

		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(innerStackP);
	}

	private void suspendNow() {
		if (runThread != null) { // avoid NullPointerException
			runThread.suspend();
		}
	}

	private void resumeNow() {
		if (runThread != null) { // avoid NullPointerException
			runThread.resume();
		}
	}

	public void run() {
		try {
			// Store this for the suspendNow() and
			// resumeNow() methods to use.
			runThread = Thread.currentThread();
			int count = 0;

			while (true) {
				// each time through, show the next symbol
				symbolTF.setText(symbolList[count % symbolList.length]);
				Thread.sleep(200);
				count++;
				System.out.println("Running with counter :"+count);
			}
		} catch (InterruptedException x) {
			// ignore
		} finally {
			// The thread is about to die, make sure that the
			// reference to it is also lost.
			runThread = null;
		}
	}
	
	public void windowStateChanged(WindowEvent e){
		   // minimized
		   if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED){
			   if (runThread != null) { // avoid NullPointerException
				   System.out.println("Suspending now..");
					//runThread.suspend();
			   }
		   }
		   // maximized
		   else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH){
			   if (runThread != null) { // avoid NullPointerException
				   System.out.println("Resuming now..");
					//runThread.resume();
			   }
		   }
		}


	public static void main(String[] args) {
		VisualSuspendResume vsr = new VisualSuspendResume();
		Thread t = new Thread(vsr);
		t.start();

		JFrame f = new JFrame("Visual Suspend Resume");
		f.setContentPane(vsr);
		f.setSize(320, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		/*f.addWindowStateListener(new WindowStateListener() {
		   public void windowStateChanged(WindowEvent event) {
		      windowStateChanged(event);
		   }
		});*/
	}
}