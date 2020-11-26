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

}
