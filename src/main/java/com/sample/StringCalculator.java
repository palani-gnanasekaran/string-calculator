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
			if(values.length == 1 ) {
				return intValue(values[0]);
			}
			return intValue(values[0]) + intValue(values[1]);
		}
	}
}
