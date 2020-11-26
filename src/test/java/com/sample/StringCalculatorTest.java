package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();
	
	@Test
	@DisplayName("with empty string input")
	public void testWithEmptyString() {
		int result = calculator.add("");
		assertEquals(0, result);
	}
	
	@Test
	@DisplayName("with 1 Number input")
	public void testWithSingleNumber() {
		int result = calculator.add("2");
		assertEquals(2, result);
	}
	
	@Test
	@DisplayName("with 2 Numbers input comma delimited")
	public void testWithTwoNumbers() {
		int result = calculator.add("2,3");
		assertEquals(5, result);
	}
	

	@Test
	@DisplayName("with 3 Numbers input comma delimited")
	public void testWithThreeNumbers() {
		int result = calculator.add("6,2,3");
		assertEquals(11, result);
	}
	

	@Test
	@DisplayName("with 5 Numbers input comma delimited")
	public void testWithFiveNumbers() {
		int result = calculator.add("1,2,3,5,6");
		assertEquals(17, result);
	}
	

	@Test
	@DisplayName("with 5 Numbers delimited by comma & new line")
	public void testWithFiveNumberNewLineDelimited() {
		int result = calculator.add("1,2,3,5\n6");
		assertEquals(17, result);
	}

	@Test
	@DisplayName("with 5 Numbers delimited by customized delimiter")
	public void testWithFiveNumberCustomizedDelimitor() {
		int result = calculator.add("//@\n1@2@3@5@6");
		assertEquals(17, result);
	}


}
