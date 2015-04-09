package com.murali.examples.lambda.basics;

public class Letter {

	public static String addHeader(String text) {
		return "From Murali Pagadala: \n\t" + text;
	}

	public static String addFooter(String text) {
		return text + " \nKind regards";
	}

	public static String checkSpelling(String text) {
		return text.replaceAll("labda", "lambda");
	}
}
