package com.thread.examples.paulhyde.basic.swing;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class ThreadViewerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 301902204478026457L;

	private Object dataLock;
	private int rowCount;
	private Object[][] cellData;
	private Object[][] pendingCellData;

	private final int columnCount;
	private final String[] columnName;
	private final Class[] columnClass;

	private Thread internalThread;
	private volatile boolean noStopRequested;

	public ThreadViewerTableModel() {
		rowCount = 0;
		cellData = new Object[0][0];

		String[] names = { "Priority", "Alive", "Daemon", "Interrupted",
				"ThreadGroup", "Thread Name" };
		columnName = names;

		Class[] classes = { Integer.class, Boolean.class, Boolean.class,
				Boolean.class, String.class, String.class };
		columnClass = classes;

		columnCount = columnName.length;

		dataLock = new Object();
		noStopRequested = true;

		Runnable run = new Runnable() {
			public void run() {
				try {
					runWork();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		internalThread = new Thread(run, "ThreadViewer");
		internalThread.setPriority(Thread.MAX_PRIORITY - 2);
		internalThread.setDaemon(true);
		internalThread.start();
	}

	private void runWork() {
		Runnable transferPending = new Runnable() {
			public void run() {
				transferPendingCellData();
				fireTableDataChanged();
			}
		};

		while (noStopRequested) {
			try {
				createPendingCellData();
				SwingUtilities.invokeAndWait(transferPending);
				Thread.sleep(5000);
			} catch (InvocationTargetException ite) {
				ite.printStackTrace();
				stopRequest();
			} catch (InterruptedException ie) {
				Thread.currentThread().interrupt();
			}
		}
	}

	private void createPendingCellData() {
		Thread[] thread = findAllThreads();
		Object[][] cell = new Object[thread.length][columnCount];

		for (int i = 0; i < thread.length; i++) {
			Thread t = thread[i];
			Object[] rowCell = cell[i];
			rowCell[0] = new Integer(t.getPriority());
			rowCell[1] = new Boolean(t.isAlive());
			rowCell[2] = new Boolean(t.isDaemon());
			rowCell[3] = new Boolean(t.isInterrupted());
			rowCell[4] = t.getThreadGroup().getName();
			rowCell[5] = t.getName();
		}

		synchronized (dataLock) {
			pendingCellData = cell;
		}
	}

	private void transferPendingCellData() {
		synchronized (dataLock) {
			cellData = pendingCellData;
			rowCount = cellData.length;
		}
	}

	public void stopRequest() {
		noStopRequested = false;
		internalThread.interrupt();
	}

	private boolean isAlive() {
		return internalThread.isAlive();
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Object getValueAt(int row, int col) {
		return cellData[row][col];
	}

	public Class getColumnClass(int columnIdx) {
		return columnClass[columnIdx];
	}

	public String getColumnName(int columnIdx) {
		return columnName[columnIdx];
	}

	public static Thread[] findAllThreads() {
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		ThreadGroup topGroup = threadGroup;

		while (threadGroup != null) {
			topGroup = threadGroup;
			threadGroup = threadGroup.getParent();
		}

		int estimatedSize = topGroup.activeCount() * 2;
		Thread[] slackList = new Thread[estimatedSize];

		int actualSize = topGroup.enumerate(slackList);

		Thread[] list = new Thread[actualSize];
		System.arraycopy(slackList, 0, list, 0, actualSize);
		return list;
	}

}