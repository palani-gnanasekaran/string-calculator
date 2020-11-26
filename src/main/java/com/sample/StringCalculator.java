package com.sample;

public class StringCalculator {
	
	private int intValue( String value ) {
		return Integer.parseInt(value);
	}
	public int add(String numbers) {
		if( "".equals(numbers) )
			return 0;
		else {
			String delimiter = ",|\n";
			String input = numbers;
			if( numbers.startsWith("//") ) {
				String[] values = numbers.split("\n");
				delimiter=values[0].substring(2);
				input = values[1];
			}
			String[] values = input.split(delimiter);
			int result = 0;
			for( String value : values ) {
				result += intValue(value);
			}
			return result;
		}
	}
}
