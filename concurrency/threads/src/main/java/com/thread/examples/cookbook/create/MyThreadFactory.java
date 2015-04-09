package com.thread.examples.cookbook.create;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;


public class MyThreadFactory implements ThreadFactory {

        private int counter;
        private String name;
        private List<String> stats;

        public MyThreadFactory(String name){
                this.counter = 0;
                this.name = name;
                this.stats = new ArrayList<String>();
        }

        /* (non-Javadoc)
         * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
         */
        public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, name+"-Thread_"+counter);
                counter++;
                stats.add(String.format("Created thread %d with name %s on %s\n", thread.getId(), thread.getName(), new Date()));
                return thread;
        }

        public String getStats() {
                StringBuffer buffer = new StringBuffer();
                Iterator<String> it = stats.iterator();
                while (it.hasNext()) {
                        buffer.append(it.next());
                        buffer.append("\n");
                }
                return buffer.toString();
        }

}