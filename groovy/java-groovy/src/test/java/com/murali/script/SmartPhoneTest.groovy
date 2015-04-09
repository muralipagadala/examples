package com.murali.script


import org.testng.annotations.Test;

import com.murali.script.groovy.ast.SmartPhone;

public class SmartPhoneTest {

	SmartPhone phone = new SmartPhone();
	
	@Test
	void testPhone() {
		assert "dialing 555-1234" == phone.dial("555-1234");
	}
	@Test
	void testCamera() {
		assert "taking picture" == phone.takePicture();
	}
}
