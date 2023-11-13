/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

// TODO: extend the Thread class
public class MessagePrinter extends Thread {
    private final String message;
    private int count;
    private long interval;

    public MessagePrinter(String message) {
        this.message = message;
        // TODO: set the thread name [important when debugging]
        setName("Message Printer");
    }

    public MessagePrinter(String message, int count, long interval) {
        this.message = message;
        this.count = count;
        this.interval = interval;
    }

    /**
     * TODO: implement run() as follows:
     * It should loop 10 times, printing the 'message' field to stdout,
     * then pausing for some interval (in millis) that you choose.
     * <p>
     * Use a try/catch to call Thread.sleep(interval) for the pause.
     * The sleep() method throws InterruptedException, which you need to catch.
     * You can either leave the catch block empty, or print the exception to stdout.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": " + message);

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored) {

            }
        }
    }
}