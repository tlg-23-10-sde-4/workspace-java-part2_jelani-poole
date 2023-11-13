/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient implements Runnable{

    public static void main(String[] args) {
        // TODO: create two instances of your thread subclass and start them up

        MessagePrinter printer1 = new MessagePrinter("roses are red", 10, 3000);
        Thread thd1 = new Thread (printer1);
        printer1.start();

        MessagePrinter printer2 = new MessagePrinter("violets are blue", 100, 200);
        Thread thd2 = new Thread (printer2);
        printer2.start();

        MessagePrinter printer3 = new MessagePrinter("everything is red");
        Thread thd3 = new Thread (printer3);
        printer3.start();

        MessagePrinter printer4 = new MessagePrinter("OH GOD, THE GARDEN IS ON FIRE", 16, 2000);
        Thread thd4 = new Thread (printer4);
        printer4.start();
    }


    @Override
    public void run() {

    }
}