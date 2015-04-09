package com.murali.groovy.language.closures

public class JavaObject {
	public static void javaSays(final String s) {
		System.out.println("Java says: Hello " + s + "!");
	}
}

def names = ['groovy', 'java', 'murali']
names.each{println 'Normal closure says Hi '+it+'!'}

def groovySays(s){
	println "Groovy say Hi $s !"
}

names.each{this.&groovySays(it)}

def javaSays = JavaObject.&javaSays
names.each javaSays