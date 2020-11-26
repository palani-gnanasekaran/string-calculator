package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();
	
	@Test
	@DisplayName("String Calculator with Empty String Test")
	public void testWithEmptyString() {
		int result = calculator.add("");
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("String Calculator with Single Number Test")
	public void testWithSingleNumberString() {
		int result = calculator.add("2");
		assertEquals(2, result);
	}
	
	@Test
	@DisplayName("String Calculator with Two Numbers Test")
	public void testWithTwoNumberString() {
		int result = calculator.add("2,3");
		assertEquals(5, result);
	}
	

	@Test
	@DisplayName("String Calculator with Three Numbers Test")
	public void testWithThreeNumberString() {
		int result = calculator.add("6,2,3");
		assertEquals(11, result);
	}
	

	@Test
	@DisplayName("String Calculator with Five Numbers Test")
	public void testWithFiveNumberString() {
		int result = calculator.add("1,2,3,5,6");
		assertEquals(17, result);
	}

}
