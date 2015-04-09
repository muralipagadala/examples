package com.murali.functional.simple;

public class Messenger {
    private static String message;
    
    public static void main(String...args){
        message = "Test This from lambda";
        Messenger msger = new Messenger();
        msger.sendMessage();
    }
    
    public void sendMessage(){
        Runnable r = ()->System.out.println(this.message);
        r.run();
    }
}
