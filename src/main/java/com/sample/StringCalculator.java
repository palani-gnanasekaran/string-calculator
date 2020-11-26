package com.sample;

public class StringCalculator {
	
	private int intValue( String value ) {
		return Integer.parseInt(value);
	}
	public int add(String numbers) {
		if( "".equals(numbers) )
			return 0;
		else {
			String[] values = numbers.split(",");
			int result = 0;
			for( String value : values ) {
				result += intValue(value);
			}
			return result;
		}
	}
}
