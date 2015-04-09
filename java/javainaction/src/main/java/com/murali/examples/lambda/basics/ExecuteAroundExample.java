package com.murali.examples.lambda.basics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundExample {

	public static void main(String...args) throws IOException{
		System.out.println("Limited Behavior         :"+processFileLimitedBehavior());
		System.out.println("Print Two Lines behavior :"+processFile((BufferedReader br) -> br.readLine() + br.readLine()));
		System.out.println("Print one line behavior  :"+processFile((BufferedReader br) -> br.readLine()));
	}
	
	public static String processFileLimitedBehavior()throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("pom.xml"))){
			return br.readLine();
		}
	}
	
	public static String processFile(BufferedReaderProcessor p) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("pom.xml"))){
			return p.process(br);
		}
	}
	
	//WHY I CAN'T DO THIS
	/*public static <T> String processFile(Processor<T> processor) throws IOException{
		try(BufferedReader br = new BufferedReader(new FileReader("pom.xml"))){
			return processor.process(br);
		}
	}*/
	
	@FunctionalInterface
	public interface BufferedReaderProcessor{
		public String process(BufferedReader br)throws IOException;
	}
	
	@FunctionalInterface
	public interface Processor<T>{
		public String process(T t)throws IOException;
	}
}
