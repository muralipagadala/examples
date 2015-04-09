package com.murali.spring.groovy.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext ctx = 
        		new FileSystemXmlApplicationContext("resources/context.xml");
        Evaluator e = null;
        boolean ok;
        
        for (int i = 0; i < 20; i++) {
            e = (Evaluator) ctx.getBean("groovyEvaluator");
            ok = e.approve(null);
            System.out.println(ok ? "approved" : "denied");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        
        ((FileSystemXmlApplicationContext) ctx).close();
    }
}
