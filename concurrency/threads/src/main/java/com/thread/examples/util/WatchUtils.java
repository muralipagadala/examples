package com.thread.examples.util;


import org.springframework.util.StopWatch;

public class WatchUtils {
        private static StopWatch watch = null;
        private static final String ASSERT_MSG = "StopWatch should be instantiated with resetAllTasks()";

        /**
         * creates the Task with name specified
         *
         * @param taskName
         */
        public static void startTask(String taskName) {
                watch.start(taskName);
        }

        /**
         * End's the current task
         *
         */
        public static void endTask() {
                watch.stop();
        }

        /**
         * prints the summary of Time consumed in formatted manner
         *
         * @return
         */
        public static String getTaskSummary() {
                return watch.prettyPrint();
        }

        /*
         * reset's all Old task and create the fresh StopWatch
         */
        public static void resetAllTasks() {
                watch = new StopWatch("[DEBUG]");
        }

}