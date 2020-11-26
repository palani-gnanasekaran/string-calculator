package com.sample;

import java.util.ArrayList;
import java.util.List;

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
			List<Integer> numberList = new ArrayList<>();
			List<Integer> negativeList = new ArrayList<>();
			for( String value : values ) {
				int intVal = intValue(value);
				if( intVal < 0 ) {
					negativeList.add(intVal);
				} else if( intVal <= 1000 ) {
					numberList.add(intVal);
				}
			}
			if( !negativeList.isEmpty() ) {
				throw new IllegalArgumentException("negatives not allowed " + negativeList.toString());
			}
			
			int result = 0;
			for( Integer value : numberList ) {
				result += value;
			}
			return result;
		}
	}
}
