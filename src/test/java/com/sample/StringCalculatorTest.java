package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	
	@Test
	@DisplayName("with 5 Numbers delimited by comma(including negative number)")
	public void testWithFiveNumberIncludesNegative() {
		assertThrows(IllegalArgumentException.class,()-> calculator.add("1,2,3,5,-6") );

		try {
			calculator.add("1,2,3,5,-6");
		} catch( IllegalArgumentException ex ) {
			assertEquals("negatives not allowed [-6]", ex.getMessage());
		}
	}
	
	@Test
	@DisplayName("with 5 Numbers delimited by comma(including negative number(s))")
	public void testWithFiveNumberIncludesMultipleNegativeNos() {
		assertThrows( IllegalArgumentException.class , () -> calculator.add("1,2,-3,5,-6") );
		try {
			calculator.add("1,2,-3,5,-6");
		} catch( IllegalArgumentException ex ) {
			assertEquals("negatives not allowed [-3, -6]", ex.getMessage());
		}
	}
	
	@Test
	@DisplayName("with 5 Numbers delimited by comma(including bigger number)")
	public void testWithFiveNumberIncludesBiggerNo() {
		int result = calculator.add("1,8,4,5,1006");
		assertEquals(18, result);
	}
	
	@Test
	@DisplayName("with 5 Numbers delimited by comma(including bigger number(s))")
	public void testWithFiveNumberIncludesBiggerNos() {
		int result = calculator.add("1,2,8,1001,3000");
		assertEquals(11, result);
	}
	
	@Test
	@DisplayName("with 3 Numbers delimited by @@@ delimiter")
	public void testWithThreeNumberAnyLengthDelimiter() {
		int result = calculator.add("//[@@@]\n1@@@8@@@12");
		assertEquals(21, result);
	}

	@Test
	@DisplayName("with 3 Numbers delimited by multiple delimiter")
	public void testWithThreeNumberMultipleDelimiter() {
		int result = calculator.add("//\\[*\\][%]\n1*6%12");
		assertEquals(19, result);
	}
}
