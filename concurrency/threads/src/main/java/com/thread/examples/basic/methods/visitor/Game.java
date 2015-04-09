package com.thread.examples.basic.methods.visitor;

import com.thread.examples.basic.methods.visitor.PingPong;

public class Game {

        public static void main(String args[]) {
                PingPong table = new PingPong();
                Thread alice = new Thread(new Player("bob", table));
                Thread bob = new Thread(new Player("chuck", table));
                Thread chuck = new Thread(new Player("alice", table));

                alice.setName("alice");
                bob.setName("bob");
                chuck.setName("chuck");

                alice.start(); // alice starts playing
                bob.start(); // bob starts playing
                chuck.start();
                try {
                        // Wait 5 seconds
                        Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                }

                table.hit("DONE"); // cause the players to quit their threads.
                try {
                        Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                }
        }
}