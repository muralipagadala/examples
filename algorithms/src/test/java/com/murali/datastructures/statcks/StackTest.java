package com.murali.datastructures.statcks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.murali.datastructures.stacks.Stack;

public class StackTest {

	private Stack stack;
	
	@BeforeMethod
	public void setUp(){
		stack = new Stack();
	}
	
	@AfterMethod
	public void tearDown(){
		stack = null;
	}
	
	@Test
	public void testPush(){
		stack.push(5);
		stack.push(6);
		assertEquals(6, stack.pop());
		assertEquals(5, stack.pop());
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testPushCharacter(){
		Stack stack = new Stack(10);
		stack.push('M');
		stack.push('u');
		stack.push('r');
		stack.push('a');
		stack.push('l');
		stack.push('i');
		String reverse = "";
		while(!stack.isEmpty()){
			reverse += (char)stack.pop();
		}
		assertEquals("ilaruM", reverse); 
	}
	
	@Test
	public void testDelimeterCheck(){
		String text = "a{b(c]d}e";
		Stack stack = new Stack(text.length());
		
		for(int i = 0; i < text.length(); i++){
			char ch = text.charAt(i);
			switch(ch){
				case '{':
				case '[':
				case '(':
						stack.push(ch);
						break;
				case '}':
				case ']':
				case ')':
					if(!stack.isEmpty()){
						char chx = (char)stack.pop();
						if( (ch=='}' && chx!='{') || (ch==']' && chx!='[') || (ch==')' && chx!='(') ){
							System.out.println("Error: "+ch+" at "+i);
						}
					}else{
						System.out.println("Error: "+ch+" at "+i);
					}
					break;
				default:
					break;
			}
		}
		if( !stack.isEmpty() ){
			System.out.println("Error: missing right delimiter");
		}
	}
	
	@Test(expectedExceptions={RuntimeException.class}, expectedExceptionsMessageRegExp="Stack is full can't push an item.")
	public void testPushWhenTheStackIsFullWithException(){
		stack.push(20); 
		stack.push(40);
		stack.push(60);
		stack.push(80);
		stack.push(100);
		stack.push(120);
	}
	
	@Test
	public void testStackSize(){
		assertEquals(0, stack.size());
		stack.push(5);
		stack.push(6);
		assertEquals(2, stack.size());
	}
	
	@Test
	public void testEmpty(){
		stack.push(20); 
		stack.push(40);
		stack.push(60);
		stack.push(80);
		
		assertEquals(80, stack.pop());
		assertEquals(60, stack.pop());
		assertEquals(40, stack.pop());
		assertEquals(20, stack.pop());
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPeek(){
		stack.push(20); 
		stack.push(40);
		
		assertEquals(40, stack.peek());
		assertEquals(40, stack.peek());
	}
}
