package com.sample;

public class StringCalculator {
	
	public int add(String numbers) {
		if( "".equals(numbers) )
			return 0;
		else {
			return Integer.parseInt(numbers);
		}
	}
}
