package com.thread.examples.exception;

public class NegativeSemaphoreException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public NegativeSemaphoreException() {
                super("Semaphore given a negative count");
        }
}